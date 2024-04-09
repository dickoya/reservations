package com.reservations.reservations.controllers;

import com.reservations.reservations.models.RepresentationUser;
import com.reservations.reservations.models.Role;
import com.reservations.reservations.models.User;
import com.reservations.reservations.services.RepresentationUserService;
import com.reservations.reservations.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AccountController {

    @Autowired
    UserService userService;

    @Autowired
    RepresentationUserService representationUserService;

    @GetMapping("/profile")
    public String profile(
            @AuthenticationPrincipal org.springframework.security.core.userdetails.User loggedUser,
            Model model) {
        var u = userService.findByLogin(loggedUser.getUsername());
        model.addAttribute("user", u);
        return "account/profile";
    }

    @PostMapping("/profile")
    public RedirectView processProfile(RedirectAttributes redirectAttributes, @AuthenticationPrincipal org.springframework.security.core.userdetails.User loggedUser, User user) {
        var u = userService.findByLogin(loggedUser.getUsername());
        System.out.println(u.getId());
        System.out.println(u.getLogin());
        System.out.println(u.getEmail());
        System.out.println(u.getRole());


//        u.setLogin(user.getLogin());
        u.setEmail(user.getEmail());
        u.setFirstname(user.getFirstname());
        u.setLastname(user.getLastname());
        u.setLanguage(user.getLanguage());

        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            u.setPassword(user.getPassword());
        }

        userService.save(u);

        redirectAttributes.addFlashAttribute("message_success", "Votre profil a été mis à jour!");

        return new RedirectView("profile");
    }

    @GetMapping("/my-tickets")
    public String myTickets(
            @AuthenticationPrincipal org.springframework.security.core.userdetails.User loggedUser,
            Model model) {
        var u = userService.findByLogin(loggedUser.getUsername());
        var representation_users = representationUserService.findByUser(u);
        model.addAttribute("user", u);
        model.addAttribute("representationUsers", representation_users);

        return "account/my_tickets.html";
    }
}
