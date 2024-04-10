package com.example.hotelmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.hotelmanagement.model.Booking;
import com.example.hotelmanagement.model.Customer;
import com.example.hotelmanagement.model.Room;
import com.example.hotelmanagement.service.BookingService;
import com.example.hotelmanagement.service.CustomerService;
import com.example.hotelmanagement.service.RoomService;

@Controller
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private RoomService roomService;

    @GetMapping("/bookings")
    public String getAllBookings(Model model) {
        model.addAttribute("bookings", bookingService.getAllBookings());
        model.addAttribute("customers", customerService.getAllCustomers());
        model.addAttribute("rooms", roomService.getAllRooms());
        return "bookings";
    }

    @PostMapping("/bookings/add")
    public String addBooking(Booking booking) {
        bookingService.addBooking(booking);
        return "redirect:/bookings";
    }
}

