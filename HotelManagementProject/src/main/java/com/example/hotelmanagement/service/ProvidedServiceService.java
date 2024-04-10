package com.example.hotelmanagement.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotelmanagement.model.ProvidedService;
import com.example.hotelmanagement.repository.ServiceRepository;

import java.util.List;

@Service
public class ProvidedServiceService {
    
    @Autowired
    private ServiceRepository providedServiceRepository;

    public List<ProvidedService> getAllProvidedServices() {
        return providedServiceRepository.findAll();
    }

    public ProvidedService getProvidedServiceById(Long id) {
        return providedServiceRepository.findById(id).orElse(null);
    }

    public ProvidedService createOrUpdateProvidedService(ProvidedService providedService) {
        return providedServiceRepository.save(providedService);
    }

    public void deleteProvidedService(Long id) {
        providedServiceRepository.deleteById(id);
    }
}