package com.reservations.reservations.controllers.api;

import com.reservations.reservations.models.Show;
import com.reservations.reservations.services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/shows")
public class ApiShowController {

    @Autowired
    private ShowService showService;

    @GetMapping()
    public Iterable<Show> getAll() {
        return showService.findAll();
    }

    @GetMapping("/{id}")
    public Show getById(@PathVariable Long id) {
        return showService.findById(id);
    }

    @PostMapping()
    public Show post(@RequestBody Show show) {
        return showService.save(show);
    }

    @PutMapping()
    public Show put(@RequestBody Show show) {
        Show foundShow = showService.findById(show.getId());
        if (foundShow == null)
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Show not found"
            );
        return showService.save(show);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        showService.deleteById(id);
    }
}

