package com.example.hotelmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.hotelmanagement.model.Booking;
import com.example.hotelmanagement.service.BookingService;

@Controller
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/bookings")
    public String getAllBookings(Model model) {
        model.addAttribute("bookings", bookingService.getAllBookings());
        return "bookingList"; // Assuming Thymeleaf template name is bookingList.html
    }

    // Other CRUD operations for Booking entity can be added here
}