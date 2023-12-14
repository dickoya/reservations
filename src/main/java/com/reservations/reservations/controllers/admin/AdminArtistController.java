package com.reservations.reservations.controllers.admin;

import com.reservations.reservations.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/artists")
public class AdminArtistController {

    @Autowired
    private ArtistRepository artistRepository;

    @GetMapping()
    public String list(ModelMap model) {
        model.addAttribute("artists", artistRepository.findAll());
        return "admin/artists/list"; // Returns the template name "index"
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Long id, ModelMap model) {
        model.addAttribute("artist", artistRepository.findById(id).orElse(null));
        return "admin/artists/show"; // Returns the template name "index"
    }
}
