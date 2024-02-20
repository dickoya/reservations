package com.reservations.reservations.services;

import com.reservations.reservations.models.Locality;
import com.reservations.reservations.repositories.LocalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalityService {
    @Autowired
    private LocalityRepository localityRepository;

    public List<Locality> getAllLocalities() {
        return localityRepository.findAll();
    }

    public Iterable<Locality> findAll() {
        return localityRepository.findAll();
    }

    // Autres méthodes pour d'autres opérations métier

}
