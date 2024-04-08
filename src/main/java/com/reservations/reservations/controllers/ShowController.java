package com.reservations.reservations.controllers;

import com.reservations.reservations.repositories.RepresentationUserRepository;
import com.reservations.reservations.repositories.ShowRepository;
import com.reservations.reservations.services.ShowService;
import com.reservations.reservations.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ShowController {

    @Autowired
    ShowService showService;

    @Autowired
    RepresentationUserRepository ruRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    UserService userService;

    @GetMapping("/shows/{id}")
    public String show(@PathVariable Long id, ModelMap model) {
        model.addAttribute("show", showService.findById(id));
        return "shows/show";
    }

}
