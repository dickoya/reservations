package com.reservations.reservations.services;

import com.reservations.reservations.models.Types;
import com.reservations.reservations.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {
    @Autowired
    private TypeRepository typeRepository;

    // Add methods for business logic

    public List<Types> getAllTypes() {
        return typeRepository.findAll();
    }
}
