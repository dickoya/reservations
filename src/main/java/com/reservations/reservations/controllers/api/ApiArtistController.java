package com.reservations.reservations.controllers.api;

import com.reservations.reservations.models.Artist;
import com.reservations.reservations.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/artists")
public class ApiArtistController {

    @Autowired
    private ArtistRepository artistRepository;

    @GetMapping()
    public Iterable<Artist> getAll() {
        return artistRepository.findAll();
    }

    @GetMapping("/{id}")
    public Artist getById(@PathVariable Long id) {
        return artistRepository.findById(id).orElseThrow(() -> new RuntimeException("Artist not found"));
    }

    @PostMapping()
    public Artist post(@RequestBody Artist artist) {
        return artistRepository.save(artist);
    }

    @PutMapping()
    public Artist put(@RequestBody Artist artist) {
        Artist foundArtist = artistRepository.findById(artist.getId()).orElse(null);
        if (foundArtist == null)
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Artist not found"
            );
        return artistRepository.save(artist);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        artistRepository.deleteById(id);
    }
}

