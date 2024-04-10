package com.example.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hotelmanagement.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{

}
