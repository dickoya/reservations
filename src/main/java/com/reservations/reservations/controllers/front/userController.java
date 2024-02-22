package com.reservations.reservations.controllers.front;

import com.reservations.reservations.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/front/users")
public class userController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public String list(ModelMap model) {
        model.addAttribute("users", userService.findAll());
        return "front/users/list"; // Returns the template name "index"
    }

   /* @GetMapping("/{id}")
    public String show(@PathVariable Long id, ModelMap model) {
        model.addAttribute("users", userService.findById(id));
        return "front/users/show"; // Returns the template name "index"
    }*/
}
