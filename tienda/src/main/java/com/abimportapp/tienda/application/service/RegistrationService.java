package com.abimportapp.tienda.application.service;

import com.abimportapp.tienda.domain.Usuario;

public class RegistrationService {
    private final UserService userService;

    public RegistrationService(UserService userService) {
        this.userService = userService;
    }
    public void register(Usuario user){
        userService.createdUser(user);
    }
}
