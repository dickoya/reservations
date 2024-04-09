package com.reservations.reservations.controllers;

import com.reservations.reservations.services.ShowService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PagesController {
    @Autowired
    ShowService showService;

    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(defaultValue = "") String searchString,
                        @RequestParam(defaultValue = "0") int page,
                        @RequestParam(defaultValue = "9") int size,
                        @RequestParam(defaultValue = "title") String sortBy,
                        @RequestParam(defaultValue = "asc") String sortOrder
    ) {
        var pageResult = showService.findBy(searchString, page, size, sortBy, sortOrder);

        model.addAttribute("shows", pageResult);
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