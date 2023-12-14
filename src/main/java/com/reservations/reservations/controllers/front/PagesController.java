package com.reservations.reservations.controllers.front;

import com.reservations.reservations.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {

    @Autowired
    private ArtistRepository artistRepository;

    @GetMapping("/")
    public String index() {
        return "front/index"; // Returns the template name "index"
    }
}
