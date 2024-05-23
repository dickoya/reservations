package com.reservations.reservations.controllers;

import com.reservations.reservations.models.Locality;
import com.reservations.reservations.services.LocalityService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import java.util.List;

@Controller
public class LocalityController {

    @Autowired
    LocalityService localityServices;

    @GetMapping("/localities")
    public String index2(Model model) {
        List<Locality> localities = localityServices.getAll();

        model.addAttribute("localities", localities);
        model.addAttribute("title", "Liste des localités");

        return "localities/index";
    }

    @GetMapping("/localities/{id}")
    public String show(Model model, @PathVariable("id") String id) {
        Locality locality = localityServices.get(id);

        model.addAttribute("locality", locality);
        model.addAttribute("title", "Fiche d'une localité");

        return "localities/show";
    }

    @GetMapping("/localities/create")
    public String create(Model model) {
        Locality localitye = new Locality(null,null);

        model.addAttribute("localitye", localitye);

        return "localities/create";
    }

    @PostMapping("/localities/create")
    public String store(@Valid @ModelAttribute("localitye") Locality localitye, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "localities/create";
        }

        localityServices.add(localitye);

        return "redirect:/localities/" + localitye.getId();
    }

    @DeleteMapping("/localities/{id}")
    public String delete(@PathVariable("id") String id, Model model) {
        try {
            Locality existing = localityServices.get(id);
            if (existing != null) {
                localityServices.delete(id);
                model.addAttribute("successMessage", "Localité supprimée avec succès.");
            } else {
                model.addAttribute("deleteError", "Localité non trouvée.");
            }
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("deleteError", "Suppression impossible: Cette localité est utilisée pour une représentation ou une location.");
            model.addAttribute("localityId","id");
        }
        return "redirect:/localities";
    }

    @GetMapping("/localities/{id}/edit")
    public String edit(Model model, @PathVariable("id") String id, HttpServletRequest request) {
        Locality localitye = localityServices.get(id);

        model.addAttribute("localitye", localitye);


        //Générer le lien retour pour l'annulation
        String referrer = request.getHeader("Referer");

        if(referrer!=null && !referrer.equals("")) {
            model.addAttribute("back", referrer);
        } else {
            model.addAttribute("back", "/localities/"+localitye.getId());
        }

        return "localities/edit";
    }

    @PutMapping("/localities/{id}/edit")
    public String update(@Valid @ModelAttribute("localitye") Locality localitye , BindingResult bindingResult, @PathVariable("id") String id, Model model) {

        if (bindingResult.hasErrors()) {
            return "localities/edit";
        }

        Locality existing = localityServices.get(id);

        if(existing==null) {
            return "localities/index";
        }

        Long indice = (long) Integer.parseInt(id);

        localitye.setId(indice);
        localityServices.update(localitye.getId(), localitye);

        model.addAttribute("locality", localitye);

        return "redirect:/localities/"+localitye.getId();
    }

}

