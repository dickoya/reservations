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
    public Locality save(Locality local) {
        return localityRepository.save(local);
    }

    public void delete(Locality local) {
        localityRepository.delete(local);
    }

    public void deleteById(Long id) {
        localityRepository.deleteById(id);
    }






    // Autres méthodes pour d'autres opérations métier

}
