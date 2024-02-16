package com.reservations.reservations.services;

import com.reservations.reservations.models.Artist;
import com.reservations.reservations.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ArtistDAO {

    @Autowired
    private ArtistRepository artistRepository;

    public Artist save(Artist artist) {
        return artistRepository.save(artist);
    }

    public Artist findById(Long id) {
        return artistRepository.findById(id).orElse(null);
    }

    public Iterable<Artist> findAll() {
        return artistRepository.findAll();
    }

    public void delete(Artist artist) {
        artistRepository.delete(artist);
    }

    public void deleteById(Long id) {
        artistRepository.deleteById(id);
    }

}
