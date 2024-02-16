package com.reservations.reservations.controllers.admin;

import com.reservations.reservations.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/users")
public class AdminUserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping()
    public String list(ModelMap model) {
        model.addAttribute("users", userRepository.findAll());
        return "admin/users/list"; // Returns the template name "index"
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Long id, ModelMap model) {
        model.addAttribute("users", userRepository.findById(id).orElse(null));
        return "admin/users/show"; // Returns the template name "index"
    }
    @PostMapping("/login")
    public String loginPage() {
        return "login";
    }




}
