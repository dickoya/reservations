package com.reservations.reservations.services;

import com.reservations.reservations.models.Locality;
import com.reservations.reservations.repositories.LocalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LocalityService {

    @Autowired
    private LocalityRepository localityRepository;

    public Locality findById(Long id) {
        return localityRepository.findById(id).orElse(null);
    }

    public Iterable<Locality> findAll() {
        return localityRepository.findAll();
    }

    public void update(Long id, Locality locality) {
        localityRepository.save(locality);
    }

    public List<Locality> getAll() {
        List<Locality> localities = new ArrayList<>();

        localityRepository.findAll().forEach(localities::add);

        return localities;
    }

    public Locality get(String id) {
        Long indice = (long) Integer.parseInt(id);
        Optional<Locality> locality = localityRepository.findById(indice);

        return locality.isPresent() ? locality.get() : null;
    }

    public void delete(String id) {
        Long indice = (long) Integer.parseInt(id);

        localityRepository.deleteById(indice);
    }

    public void add(Locality locality) {
        localityRepository.save(locality);
    }

}
