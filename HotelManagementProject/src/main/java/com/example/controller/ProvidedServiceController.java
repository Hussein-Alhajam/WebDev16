package com.example.hotelmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.hotelmanagement.models.ProvidedService;
import com.example.hotelmanagement.services.ProvidedServiceService;

@Controller
public class ProvidedServiceController {

    @Autowired
    private ProvidedServiceService providedServiceService;

    @GetMapping("/services")
    public String getAllServices(Model model) {
        model.addAttribute("services", providedServiceService.getAllServices());
        return "serviceList"; // Assuming Thymeleaf template name is serviceList.html
    }

    // Other CRUD operations for ProvidedService entity can be added here
}
