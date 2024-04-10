package com.example.hotelmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.hotelmanagement.model.Booking;
import com.example.hotelmanagement.service.BookingService;
import com.example.hotelmanagement.service.CustomerService;
import com.example.hotelmanagement.service.RoomService;

@Controller
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // Inject CustomerService and RoomService
    @Autowired
    private CustomerService customerService;

    @Autowired
    private RoomService roomService;

    @GetMapping("/bookings")
    public String showBookingForm(Model model) {
        // Fetch and add bookings, customers, and rooms to the model
        model.addAttribute("bookings", bookingService.getAllBookings());
        model.addAttribute("customers", customerService.getAllCustomers());
        model.addAttribute("rooms", roomService.getAllRooms());
        return "bookings"; // Ensure this template name matches your Thymeleaf template
    }

    @PostMapping("/bookings/add")
    public String addBooking(Booking booking) {
        bookingService.addBooking(booking);
        return "redirect:/bookings";
    }

    // Other CRUD operations for Booking entity can be added here
}
