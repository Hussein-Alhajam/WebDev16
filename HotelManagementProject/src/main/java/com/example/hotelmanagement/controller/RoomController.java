package com.example.hotelmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.hotelmanagement.model.Room;
import com.example.hotelmanagement.service.RoomService;

@Controller
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/rooms")
    public String getAllRooms(Model model) {
        model.addAttribute("rooms", roomService.getAllRooms());
        return "roomList"; // Assuming Thymeleaf template name is roomList.html
    }

    // Other CRUD operations for Room entity can be added here
}