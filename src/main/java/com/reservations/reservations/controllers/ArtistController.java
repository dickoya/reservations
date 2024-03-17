package com.reservations.reservations.controllers;
import com.reservations.reservations.models.Artist;
import com.reservations.reservations.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/artists")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @GetMapping()
    public String list(ModelMap model) {
        model.addAttribute("artists", artistService.findAll());
        return "artists/list"; // Returns the template name "index"
    }

    @GetMapping("/{id}")

    public String show(@PathVariable Long id, ModelMap model) {
        model.addAttribute("artist", artistService.findById(id));
        return "artists/show"; // Returns the template name "index"
    }
    @DeleteMapping("/{id}")
    public Artist delete(@PathVariable Long id) {
        Artist foundArtist = artistService.findById(id);
        if (foundArtist == null)
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Artist not found"
            );
        artistService.deleteById(id);
        return foundArtist;
    }
}
