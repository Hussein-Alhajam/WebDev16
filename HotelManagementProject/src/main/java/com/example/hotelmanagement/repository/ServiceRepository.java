package com.example.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hotelmanagement.model.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long>{

}
