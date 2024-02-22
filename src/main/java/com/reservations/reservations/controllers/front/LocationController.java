package com.reservations.reservations.controllers.front;

import com.reservations.reservations.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/front/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping()
    public String list(ModelMap model){
        model.addAttribute("location", locationService.findAll());
        return "front/locations/list";
    }
}
