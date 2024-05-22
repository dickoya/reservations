package com.reservations.reservations.services;

import com.reservations.reservations.models.Type;
import com.reservations.reservations.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TypeService {
    @Autowired
    private TypeRepository typeRepository;

    public Type findById(Long id) {
        return typeRepository.findById(id).orElse(null);
    }

    public Iterable<Type> findAll() {
        return typeRepository.findAll();
    }

    public void update(Long id, Type type) {
        Type type1 = typeRepository.findById(id).orElse(null);
        if(type1 != null){
            type1.setType(type.getType());
            typeRepository.save(type1);
        }
    }

    public List<Type> getAll() {
        List<Type> localities = new ArrayList<>();
        return typeRepository.findAll();
    }

    public Type get(Long id) {
        Optional<Type> type = typeRepository.findById(id);
        return type.isPresent() ? type.get() : null;
    }

    public void delete(Long id) {
        typeRepository.deleteById(id);
    }

    public Type add(Type type) {
        type.setArtists(null);
        return typeRepository.save(type);
    }
}

