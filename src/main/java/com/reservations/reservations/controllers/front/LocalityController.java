package com.reservations.reservations.controllers.front;

import com.reservations.reservations.models.Locality;
import com.reservations.reservations.services.LocalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/front/locality")
public class LocalityController {
    @Autowired
    private LocalityService localityService;


    @GetMapping()
    public String list(ModelMap model) {
        model.addAttribute("localities", localityService.findAll());
        return "front/localities/list"; // Returns the template name "index"
    }

}
