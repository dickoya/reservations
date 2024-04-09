package com.reservations.reservations.controllers;

import com.reservations.reservations.GeneralException.GeneralException;
import com.reservations.reservations.models.Locality;
import com.reservations.reservations.services.LocalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/localities")
public class LocalityController {

    @Autowired
    LocalityService localityServices;

    @GetMapping("")
    public String list(ModelMap model) {
        model.addAttribute("localities", localityServices.findAll());
        model.addAttribute("locality", new Locality());
        return "localities/list";
    }

    @PostMapping("/create")
    public RedirectView createLocality(@ModelAttribute("locality") Locality locality) throws GeneralException {
        localityServices.save(locality);
        return new RedirectView("/localities");
    }

    @GetMapping("/{id}")
    public String showEditForm(@PathVariable Long id, ModelMap model) {
        model.addAttribute("locality", localityServices.findById(id));
        return "localities/show";
    }

    @PostMapping("/edit")
    public RedirectView updateLocality(@ModelAttribute("locality") Locality locality) throws GeneralException {
        localityServices.update(locality);
        return new RedirectView("/localities");
    }

    @GetMapping("/delete/{id}")
    public RedirectView deleteLocality(@PathVariable("id") Long id) throws GeneralException {
        localityServices.delete(id);
        return new RedirectView("/localities");
    }
}

