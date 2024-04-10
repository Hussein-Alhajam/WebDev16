package com.example.hotelmanagement.service;

import com.example.hotelmanagement.model.Booking;
import com.example.hotelmanagement.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Additional methods to handle create, update, delete operations can be added here
    // For example, adding a new booking might look like this:

    public Booking addBooking(Booking booking) {
        // You can add any additional business logic before saving
        return bookingRepository.save(booking);
    }


    // You can add more methods as required for the business logic
}
