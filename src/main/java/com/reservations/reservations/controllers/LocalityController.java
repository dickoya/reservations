package com.reservations.reservations.controllers;

import com.reservations.reservations.DTO.LocalityDTO;
import com.reservations.reservations.exceptions.GeneralException;
import com.reservations.reservations.models.Locality;
import com.reservations.reservations.services.LocalityServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/localities")
public class LocalityController {

    @Autowired
    LocalityServices localityServices;

    @GetMapping("")
    public String list(ModelMap model) {
        model.addAttribute("localities", localityServices.findAll());
        model.addAttribute("locality", new LocalityDTO());
        return "localities/list";
    }

    @PostMapping("/create")
    public RedirectView createLocality(@ModelAttribute("locality") LocalityDTO locality) throws GeneralException {
        localityServices.save(Locality.toLocality(locality));
        return new RedirectView("/localities");
    }

    @GetMapping("/{id}")
    public String showEditForm(@PathVariable Long id, ModelMap model) {
        model.addAttribute("locality", localityServices.findById(id));
        return "localities/show";
    }

    @PostMapping("/edit")
    public RedirectView updateLocality(@ModelAttribute("locality") LocalityDTO locality) throws GeneralException {
        localityServices.update(Locality.toLocality(locality));
        return new RedirectView("/localities");
    }

    @GetMapping("/delete/{id}")
    public RedirectView deleteLocality(@PathVariable("id") Long id) throws GeneralException {
        localityServices.delete(id);
        return new RedirectView("/localities");
    }

}
