package com.reservations.reservations.controllers.front;

import com.reservations.reservations.models.Locality;
import com.reservations.reservations.services.LocalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/front/locality")
public class LocalityController {
    @Autowired
    private LocalityService localityService;

    @GetMapping()
    public List<Locality> getAllLocalities() {
        return localityService.getAllLocalities();
    }

  /*  @GetMapping()
    public String list(ModelMap model) {
        model.addAttribute("locality", localityService.findAll());
        return "admin/artists/list"; // Returns the template name "index"
    }*/
    /*@PostMapping
    public Locality createLocality(@RequestBody Locality locality) {
        return localityService.createLocality(locality);
    }*/
}
