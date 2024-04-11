package com.example.hotelmanagement.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//
	// foreign keys (customerId, roomId)
	//
	// There can be many customers for 1 booking
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	// There can be many rooms for 1 booking
	@ManyToOne
	@JoinColumn(name = "room_id")
	private Room room;
	
	private LocalDate startDate;
	private LocalDate endDate;
	
	// There can be many services for each booking
    @ManyToMany
    @JoinTable(name = "booking_service",
               joinColumns = @JoinColumn(name = "booking_id"),
               inverseJoinColumns = @JoinColumn(name = "service_id"))
    private List<ProvidedService> services = new ArrayList<>();
    
	// constructor
	public Booking() {}

	// parameterized constructor
	public Booking(Customer customer, Room room, LocalDate startDate, LocalDate endDate) {
		this.customer = customer;
		this.room = room;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	//
	// Getters and setters
	//
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<ProvidedService> getServices() {
		return services;
	}

	public void setServices(List<ProvidedService> services) {
		this.services = services;
	}

	
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	//
	// toString
	//
	@Override
	public String toString() {
		return "Booking [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", customer=" + customer
				+ ", room=" + room + ", services=" + services + "]";
	}
}
