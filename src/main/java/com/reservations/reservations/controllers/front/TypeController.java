package com.reservations.reservations.controllers.front;

import com.reservations.reservations.models.Types;
import com.reservations.reservations.services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("front/type")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @GetMapping()
    public String list(ModelMap model) {
        model.addAttribute("types", typeService.findAll());
        return "front/types/list"; // Returns the template name "index"
    }


// Add other endpoints as needed
}
