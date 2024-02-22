package com.reservations.reservations.controllers.admin;

import com.reservations.reservations.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/users")
public class AdminUserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String list(ModelMap model) {
        model.addAttribute("users", userService.findAll());
        return "admin/users/list"; // Returns the template name "index"
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Long id, ModelMap model) {
        model.addAttribute("users", userService.findById(id));
        return "admin/users/show"; // Returns the template name "index"
    }
}
