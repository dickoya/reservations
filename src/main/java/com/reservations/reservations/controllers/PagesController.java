package com.reservations.reservations.controllers;

import com.reservations.reservations.models.Representation;
import com.reservations.reservations.repositories.RepresentationRepository;
import com.reservations.reservations.services.RepresentationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.logging.Logger;

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
                        @RequestParam(defaultValue = "3") int size,
                        @RequestParam(defaultValue = "representationDate") String sortBy,
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
    public String handleError(HttpServletRequest request, Model model) {
        // Get the error status code
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            statusCode = 500; // Default to internal server error if status code not available
        }

        // Get the exception message
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        String errorMessage = (throwable != null) ? throwable.getMessage() : "Unknown error";

        // Add error details to the model
        model.addAttribute("statusCode", statusCode);
        model.addAttribute("errorMessage", errorMessage);

        // Return the name of the HTML template
        return "error";
    }
}