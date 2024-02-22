package com.reservations.reservations.controllers.front;

import com.reservations.reservations.services.RepresentationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping("/front/representation")
public class RepresentationController {
    @Autowired
    private RepresentationService representationService;

    @GetMapping()
    public String list(ModelMap model) {
        model.addAttribute("representation", representationService.findAll());
        return "front/representations/list"; // Returns the template name "index"
    }
    // other controller methods
}
