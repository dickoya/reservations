package com.reservations.reservations.services;

import com.reservations.reservations.models.Artist;
import com.reservations.reservations.models.Locality;
import com.reservations.reservations.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {

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

    public void deleteArtist(String id) {
        Long indice = (long) Integer.parseInt(id);

        artistRepository.deleteById(indice);
    }


    public void deleteById(Long id) {
        artistRepository.deleteById(id);
    }

    public List<Artist> getAll() {
        List<Artist> artists = new ArrayList<>();

        artistRepository.findAll().forEach(artists::add);

        return artists;
    }

    public Artist get(String id) {
        Long indice = (long) Integer.parseInt(id);
        Optional<Artist> artist = artistRepository.findById(indice);

        return artist.isPresent() ? artist.get() : null;
    }

    public void updateArtist(Long id, Artist artist) {
        artistRepository.save(artist);
    }


    public void addArtist(Artist artist) {
        artistRepository.save(artist);
    }

}
