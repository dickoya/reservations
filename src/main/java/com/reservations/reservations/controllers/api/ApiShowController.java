package com.reservations.reservations.controllers.api;

import com.reservations.reservations.models.Artist;
import com.reservations.reservations.models.Show;
import com.reservations.reservations.repositories.ArtistRepository;
import com.reservations.reservations.repositories.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/shows")
public class ApiShowController {

    @Autowired
    private ShowRepository showRepository;

    @GetMapping()
    public Iterable<Show> getAll() {
        return showRepository.findAll();
    }

    @GetMapping("/{id}")
    public Show getById(@PathVariable Long id) {
        return showRepository.findById(id).orElseThrow(() -> new RuntimeException("Show not found"));
    }

    @PostMapping()
    public Show post(@RequestBody Show show) {
        return showRepository.save(show);
    }

    @PutMapping()
    public Show put(@RequestBody Show show) {
        Show foundShow = showRepository.findById(show.getId()).orElse(null);
        if (foundShow == null)
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Show not found"
            );
        return showRepository.save(show);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        showRepository.deleteById(id);
    }
}

