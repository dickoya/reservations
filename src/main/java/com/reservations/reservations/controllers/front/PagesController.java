package com.reservations.reservations.controllers.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {

    @GetMapping("/")
    public String index() {
        return "front/index"; // Returns the template name "index"
    }

    @GetMapping("/error")
    public String error() {
        return "front/error";
    }
}
