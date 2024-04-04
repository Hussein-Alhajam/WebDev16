package com.example.hotelmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.hotelmanagement.models.Customer;
import com.example.hotelmanagement.services.CustomerService;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public String getAllCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customerList"; // Assuming Thymeleaf template name is customerList.html
    }

    // Other CRUD operations for Customer entity can be added here
}
