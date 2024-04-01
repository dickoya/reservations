package com.reservations.reservations.commands;

import com.reservations.reservations.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class MyCommands {

    @Autowired
    UserRepository userRepository;

    @ShellMethod(key = "init-passwords")
    public void helloWorld(
            @ShellOption(defaultValue = "password") String password
    ) {
        var users = userRepository.findAll();
        for (var user : users) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(password);
            user.setPassword(encodedPassword);
            userRepository.save(user);
        }
    }
}

