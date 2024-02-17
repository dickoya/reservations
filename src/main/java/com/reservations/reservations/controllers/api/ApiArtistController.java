package com.reservations.reservations.controllers.api;

import com.reservations.reservations.models.Artist;
import com.reservations.reservations.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/artists")
public class ApiArtistController {

    @Autowired
    private ArtistService artistService;

    @GetMapping()
    public Iterable<Artist> getAll() {
        return artistService.findAll();
    }

    @GetMapping("/{id}")
    public Artist getById(@PathVariable Long id) {
        return artistService.findById(id);
    }

    @PostMapping()
    public Artist post(@RequestBody Artist artist) {
        return artistService.save(artist);
    }

    @PutMapping()
    public Artist put(@RequestBody Artist artist) {
        Artist foundArtist = artistService.findById(artist.getId());
        if (foundArtist == null)
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Artist not found"
            );
        return artistService.save(artist);
    }

    @DeleteMapping("/{id}")
    public Artist delete(@PathVariable Long id) {
        Artist foundArtist = artistService.findById(id);
        if (foundArtist == null)
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Artist not found"
            );
        artistService.deleteById(id);
        return foundArtist;
    }
}

