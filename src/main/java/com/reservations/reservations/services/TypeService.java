package com.reservations.reservations.services;

import com.reservations.reservations.models.Type;
import com.reservations.reservations.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeService {
    @Autowired
    private TypeRepository typeRepository;
    public Type findByType(String type){return typeRepository.findByType(type);}

    public Type findById(Long id) {
        return typeRepository.findById(id).orElse(null);
    }

    public Iterable<Type> findAll() {
        return typeRepository.findAll();
    }


}
