package com.reservations.reservations.services;

import com.reservations.reservations.models.Representation;

import com.reservations.reservations.repositories.RepresentationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RepresentationService {
    @Autowired
    private RepresentationRepository representationRepository;

    public List<Representation> findAll() {
        return representationRepository.findAll();
    }
}
