package com.reservations.reservations.controllers.front;

import com.reservations.reservations.services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("front/shows")
public class ShowController {
    @Autowired
    ShowService showService;

    @GetMapping()
    public String list(ModelMap model){
        model.addAttribute("shows", showService.findAll());
        return "front/shows/list";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable Long id, ModelMap model){
        model.addAttribute("shows", showService.findById(id));
        return "front/shows/list";
    }
}
