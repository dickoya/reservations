package com.reservations.reservations.controllers;

import com.reservations.reservations.models.Representation;
import com.reservations.reservations.repositories.RepresentationRepository;
import com.reservations.reservations.services.RepresentationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class PagesController {
    @Autowired
    RepresentationService representationService;
    @Autowired
    RepresentationRepository representationRepository;



    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(defaultValue = "") String searchString,
                        @RequestParam(defaultValue = "0") int page,
                        @RequestParam(defaultValue = "10") int size,
                        @RequestParam(defaultValue = "when") String sortBy,
                        @RequestParam(defaultValue = "asc") String sortOrder
    ) {
        var pageResult = representationService.findBy(searchString, page, size, sortBy, sortOrder);

        model.addAttribute("representations", pageResult);
        model.addAttribute("totalPages", pageResult.getTotalPages());
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("searchString", searchString);
        model.addAttribute("sortOrder", sortOrder);
        model.addAttribute("page", page);
        return "index";
    }


    @GetMapping("/error")
    public String error() {
        return "error";
    }
}