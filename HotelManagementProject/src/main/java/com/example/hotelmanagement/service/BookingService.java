package com.example.hotelmanagement.service;

import com.example.hotelmanagement.model.Booking;
import com.example.hotelmanagement.model.ProvidedService;
import com.example.hotelmanagement.repository.BookingRepository;
import com.example.hotelmanagement.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final ServiceRepository serviceRepository; 
    
    @Autowired
    public BookingService(BookingRepository bookingRepository, ServiceRepository providedServiceRepository) {
        this.bookingRepository = bookingRepository;
        this.serviceRepository = providedServiceRepository;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking addBooking(Booking booking, List<Long> serviceIds) throws Exception {
        List<Booking> overlappingBookings = bookingRepository.findBookingsByDateOverlap(
                booking.getRoom().getId(), booking.getStartDate(), booking.getEndDate());
                
        if (!overlappingBookings.isEmpty()) {
            throw new Exception("The room is already booked for the given date(s).");
        }

        List<ProvidedService> selectedServices = serviceRepository.findAllById(serviceIds);
        booking.setServices(selectedServices);
        return bookingRepository.save(booking);
    }
}
