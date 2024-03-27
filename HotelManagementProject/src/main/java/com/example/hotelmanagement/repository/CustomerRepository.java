package com.example.hotelmanagement.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hotelmanagement.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
