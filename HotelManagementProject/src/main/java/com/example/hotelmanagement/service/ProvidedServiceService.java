package com.example.hotelmanagement.service;

import com.example.hotelmanagement.model.ProvidedService;
import com.example.hotelmanagement.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvidedServiceService {

    private final ServiceRepository serviceRepository;

    @Autowired
    public ProvidedServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<ProvidedService> getAllServices() {
        return serviceRepository.findAll();
    }

    // Method to add a new service
    public ProvidedService addService(ProvidedService service) {
        return serviceRepository.save(service);
    }

    // Method to find services by IDs - add this method
    public List<ProvidedService> findAllById(List<Long> ids) {
        return serviceRepository.findAllById(ids);
    }
}
