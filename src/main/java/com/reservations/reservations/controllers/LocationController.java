package com.reservations.reservations.controllers;

import com.reservations.reservations.exceptions.GeneralException;
import com.reservations.reservations.models.Location;
import com.reservations.reservations.services.LocalityService;
import com.reservations.reservations.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @Autowired
    private LocalityService localityServices;

    @GetMapping("")
    public String list(ModelMap model) {
        model.addAttribute("locations", locationService.findAll());
        model.addAttribute("localities", localityServices.findAll());
        model.addAttribute("location", new Location());
        return "locations/list";
    }

    @PostMapping("/create")
    public RedirectView createLocation(@ModelAttribute("location") Location location) throws GeneralException {
        locationService.save(location);
        return new RedirectView("/locations");
    }

    @GetMapping("/{id}")
    public String showEditForm(@PathVariable Long id, ModelMap model) {
        model.addAttribute("location", locationService.findById(id));
        return "locations/show";
    }

    @PostMapping("/edit")
    public RedirectView updateLocation(@ModelAttribute("location") Location location) throws GeneralException {
        locationService.update(location);
        return new RedirectView("/locations");
    }

    @GetMapping("/delete/{id}")
    public RedirectView deleteLocation(@PathVariable("id") Long id) throws GeneralException {
        locationService.delete(id);
        return new RedirectView("/locations");
    }
}
