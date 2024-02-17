package com.reservations.reservations.controllers.api;

import com.reservations.reservations.models.User;
import com.reservations.reservations.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/users")
public class ApiUserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public Iterable<User> getAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping()
    public User post(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping()
    public User put(@RequestBody User user) {
        User foundUser = userService.findById(user.getId());
        if (foundUser == null)
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User not found"
            );
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteById(id);
    }
}

