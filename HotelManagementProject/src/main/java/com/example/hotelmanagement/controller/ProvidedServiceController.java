package com.example.hotelmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.hotelmanagement.model.ProvidedService;
import com.example.hotelmanagement.service.ProvidedServiceService;

@Controller
public class ProvidedServiceController {

    @Autowired
    private ProvidedServiceService providedServiceService;

    @GetMapping("/services")
    public String getAllServices(Model model) {
        model.addAttribute("services", providedServiceService.getAllServices());
        return "service";
    }

    @PostMapping("/services/add")
    public String addService(ProvidedService service) {
        providedServiceService.addService(service);
        return "redirect:/services";
    }
}

