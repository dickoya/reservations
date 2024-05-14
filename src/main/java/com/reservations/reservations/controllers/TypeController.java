package com.reservations.reservations.controllers;

import com.reservations.reservations.models.Location;
import com.reservations.reservations.repositories.TypeRepository;
import com.reservations.reservations.services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/types")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("")
    public String list(ModelMap model) {
        model.addAttribute("types", typeService.findAll());
        return "types/list";
    }


}
