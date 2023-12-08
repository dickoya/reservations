package com.reservations.reservations.controllers.admin;

import com.reservations.reservations.repositories.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/shows")
public class AdminShowController {
    @Autowired
    ShowRepository showRepository;

    @GetMapping()
    public String list(ModelMap model){
        model.addAttribute("shows", showRepository.findAll());
        return "admin/shows/list";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable Long id, ModelMap model){
        model.addAttribute("shows", showRepository.findById(id));
        return "admin/shows/show";
    }
}
