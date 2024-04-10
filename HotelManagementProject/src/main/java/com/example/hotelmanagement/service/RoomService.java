package com.example.hotelmanagement.service;

import com.example.hotelmanagement.model.Room;
import com.example.hotelmanagement.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    // Method to add a new room
    public Room addRoom(Room room) {
        // Any business logic before saving the room
        return roomRepository.save(room);
    }


    // Additional methods as required for business logic can be added here
}
