package com.abimportapp.tienda.application.service;

import com.abimportapp.tienda.domain.Usuario;
import org.springframework.security.crypto.password.PasswordEncoder;

public class RegistrationService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;


    public RegistrationService(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }
    public void register(Usuario user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.createdUser(user);
    }
}
