package com.reservations.reservations.controllers;

import com.reservations.reservations.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class userController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public String list(ModelMap model) {
        model.addAttribute("users", userService.findAll());
        return "users/show"; // Returns the template name "index"
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteById(id);
    }



}
