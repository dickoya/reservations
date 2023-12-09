package com.reservations.reservations.controllers.api;

import com.reservations.reservations.models.Show;
import com.reservations.reservations.models.User;
import com.reservations.reservations.repositories.ShowRepository;
import com.reservations.reservations.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/users")
public class ApiUserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping()
    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @PostMapping()
    public User post(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping()
    public User put(@RequestBody User user) {
        User foundUser = userRepository.findById(user.getId()).orElse(null);
        if (foundUser == null)
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User not found"
            );
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}

