package com.reservations.reservations.controllers;
import com.reservations.reservations.models.Artist;
import com.reservations.reservations.models.Locality;
import com.reservations.reservations.services.ArtistService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
public class ArtistController {

    @Autowired
    ArtistService artistService;


    /*@GetMapping()
    public String list(ModelMap model) {
        model.addAttribute("artists", artistService.findAll());
        return "artists/list"; // Returns the template name "index"
    }*/

    @GetMapping("/artists")
    public String index2(Model model) {
        List<Artist> artists = artistService.getAll();

        model.addAttribute("artists", artists);
        model.addAttribute("title", "Liste des artistes");

        return "artists/index";
    }

    @GetMapping("/artists/create")
    public String create(Model model) {
        Artist artist = new Artist(null,null);

        model.addAttribute("artist", artist);

        return "artists/create";
    }

    @PostMapping("/artists/create")
    public String store(@Valid @ModelAttribute("artist") Artist artist, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "artists/create";
        }

        artistService.addArtist(artist);

        return "redirect:/artists/"+artist.getId();
    }


    @GetMapping("/artists/{id}")
    public String show(Model model, @PathVariable("id") String id) {
        Artist artist = artistService.get(id);

        model.addAttribute("artist", artist);
        model.addAttribute("title", "Fiche d'un artiste");

        return "artists/show";
    }


    @GetMapping("/artists/{id}/edit")
    public String edit(Model model, @PathVariable("id") String id, HttpServletRequest request) {
        Artist artist = artistService.get(id);

        model.addAttribute("artist", artist);


        //Générer le lien retour pour l'annulation
        String referrer = request.getHeader("Referer");

        if(referrer!=null && !referrer.equals("")) {
            model.addAttribute("back", referrer);
        } else {
            model.addAttribute("back", "/artists/"+artist.getId());
        }

        return "artists/edit";
    }


    @PutMapping("/artists/{id}/edit")
    public String update(@Valid @ModelAttribute("artist") Artist artist, BindingResult bindingResult, @PathVariable("id") String id, Model model) {

        if (bindingResult.hasErrors()) {
            return "artists/edit";
        }

        Artist existing = artistService.get(id);

        if(existing==null) {
            return "artists/index";
        }

        Long indice = (long) Integer.parseInt(id);

        artist.setId(indice);
        artistService.updateArtist(artist.getId(), artist);

        model.addAttribute("artist", artist);

        return "redirect:/artists/"+artist.getId();
    }

    @DeleteMapping("/artists/{id}")
    public String delete(@PathVariable("id") String id, Model model) {
        try {
            Artist existing = artistService.get(id);
            if (existing != null) {
                artistService.deleteArtist(id);
                model.addAttribute("successMessage", "Artist supprimée avec succès.");
            } else {
                model.addAttribute("deleteError", "Artist non trouvée.");
            }
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("deleteError", "Suppression impossible: Cette Artiste est utilisée.");

        }
        return "redirect:/artists";
    }


}



/*@GetMapping("/{id}")
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
    }*/

