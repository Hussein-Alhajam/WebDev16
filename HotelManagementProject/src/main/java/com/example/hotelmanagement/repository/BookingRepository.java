package com.example.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.hotelmanagement.model.Booking;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{

    @Query("SELECT b FROM Booking b WHERE b.room.id = :roomId AND NOT (b.endDate < :startDate OR b.startDate > :endDate)")
    List<Booking> findBookingsByDateOverlap(Long roomId, LocalDate startDate, LocalDate endDate);
}
