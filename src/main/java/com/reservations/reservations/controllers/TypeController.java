package com.reservations.reservations.controllers;

import com.reservations.reservations.models.Type;
import com.reservations.reservations.models.TypeDTO;
import com.reservations.reservations.services.TypeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public String index2(Model model) {
        List<Type> types = typeService.getAll();
        model.addAttribute("types", types);
        model.addAttribute("title", "Liste des localités");

        return "types/index";
    }

    @GetMapping("/types/{id}")
    public String show(Model model, @PathVariable("id") Long id) {
        Type type = typeService.get(id);

        model.addAttribute("type", type);
        model.addAttribute("title", "Fiche d'un type");

        return "types/show";
    }

    @GetMapping("/types/create")
    public String create(Model model) {
        model.addAttribute("type", new TypeDTO());
        return "types/create";
    }

    @PostMapping("/types/create")
    public String store(@ModelAttribute("type") TypeDTO type, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "types/create";
        }
        var type1 = typeService.add(Type.toType(type));
        return "redirect:/types/" + type1.getId();
    }

    @GetMapping("/types/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        try {
            Type existing = typeService.get(id);
            if (existing != null) {
                typeService.delete(id);
                model.addAttribute("successMessage", "Type supprimée avec succès.");
            } else {
                model.addAttribute("deleteError", "Type non trouvée.");
            }
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("deleteError", "Suppression impossible: Ce type est utilisée pour une représentation ou une location.");
            model.addAttribute("TypeId","id");
        }
        return "redirect:/types";
    }

    @GetMapping("/types/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id, HttpServletRequest request) {
        Type type = typeService.get(id);
        model.addAttribute("type", type);
        //Générer le lien retour pour l'annulation
        String referrer = request.getHeader("Referer");
        if(referrer!=null && !referrer.equals("")) {
            model.addAttribute("back", referrer);
        } else {
            model.addAttribute("back", "/types/"+type.getId());
        }

        return "types/edit";
    }

    @PutMapping("/types/{id}/edit")
    public String update(@Valid @ModelAttribute("Typee") Type type , BindingResult bindingResult, @PathVariable("id") Long id, Model model) {
        if (bindingResult.hasErrors()) {
            return "types/edit";
        }
        Type existing = typeService.get(id);
        if(existing==null) {
            return "types/index";
        }
        type.setId(id);
        typeService.update(type.getId(), type);
        model.addAttribute("Type", type);
        return "redirect:/types/"+type.getId();
    }
}

