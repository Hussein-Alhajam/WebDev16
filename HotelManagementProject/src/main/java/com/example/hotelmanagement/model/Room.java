package com.example.hotelmanagement.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int roomNumber;
	private String type;
	private double price;
	
	// Each room can have 1 to many bookings
	@OneToMany(mappedBy = "room")
	private List<Booking> bookings;
	
	// constructor
	public Room() {}

	// parameterized constructor
	public Room(int roomNumber, String type, double price) {
		this.roomNumber = roomNumber;
		this.type = type;
		this.price = price;
	}

	
	//
	// getters and setters
	//
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	
	//
	// toString
	//
	@Override
	public String toString() {
		return "Room [id=" + id + ", roomNumber=" + roomNumber + ", type=" + type + ", price=" + price + ", bookings="
				+ bookings + "]";
	}
}
