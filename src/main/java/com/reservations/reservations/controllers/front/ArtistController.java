package com.reservations.reservations.controllers.front;
import com.reservations.reservations.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/front/artists")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @GetMapping()
    public String list(ModelMap model) {
        model.addAttribute("artists", artistService.findAll());
        return "front/artists/list"; // Returns the template name "index"
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Long id, ModelMap model) {
        model.addAttribute("artist", artistService.findById(id));
        return "front/artists/show"; // Returns the template name "index"
    }
}
