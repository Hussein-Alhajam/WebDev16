package com.example.hotelmanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.hotelmanagement.model.Booking;
import com.example.hotelmanagement.model.Customer;
import com.example.hotelmanagement.model.Room;
import com.example.hotelmanagement.service.BookingService;
import com.example.hotelmanagement.service.CustomerService;
import com.example.hotelmanagement.service.RoomService;
import com.example.hotelmanagement.service.ProvidedServiceService;


@Controller
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private RoomService roomService;
    
    @Autowired
    private ProvidedServiceService providedServiceService;
    
    @GetMapping("/bookings")
    public String getAllBookings(Model model) {
        model.addAttribute("bookings", bookingService.getAllBookings());
        model.addAttribute("customers", customerService.getAllCustomers());
        model.addAttribute("rooms", roomService.getAllRooms());
        model.addAttribute("services", providedServiceService.getAllServices());
        return "bookings";
    }

    @PostMapping("/bookings/add")
    public String addBooking(@ModelAttribute Booking booking, 
                             @RequestParam(name = "services", required = true) List<Long> serviceIds, 
                             RedirectAttributes redirectAttributes) {
        try {
            bookingService.addBooking(booking, serviceIds);
            return "redirect:/bookings";
        } catch (Exception e) {
            e.printStackTrace();

            // Pass the error message through redirect attributes
            redirectAttributes.addFlashAttribute("errorMessage", "Unable to add booking: " + e.getMessage());

            return "redirect:/bookings";
        }
    }
}