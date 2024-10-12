package com.abimportapp.tienda.application.service;

import com.abimportapp.tienda.domain.UserType;
import com.abimportapp.tienda.domain.Usuario;
import com.abimportapp.tienda.infrastructure.dto.UserDto;

public class LoginService {
    private final UserService userService;

    public LoginService(UserService userService) {
        this.userService = userService;
    }
    //TODO: returns true if the user exists, otherwise false
    public boolean existsUser(String email) {
        try {
            Usuario usuario = userService.findByEmail(email);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    //TODO: obtains the user id by email
    public Integer getUserId(String email) {
        try {
            return userService.findByEmail(email).getId();
        } catch (Exception e) {
            return 0;
        }
    }
    public UserType getUserType(String email) {
        return userService.findByEmail(email).getUserType();
    }
    //TODO: obtains the user by email
    public Usuario getUser(String email) {
        try {
            return userService.findByEmail(email);
        } catch (Exception e) {
            return new Usuario();
        }
    }
    public Usuario getIdUser(Integer id) {
        try {
            return userService.findById(id);
        } catch (Exception e) {
            return new Usuario();
        }
    }

}
