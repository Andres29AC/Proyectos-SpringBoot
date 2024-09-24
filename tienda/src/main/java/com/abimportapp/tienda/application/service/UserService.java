package com.abimportapp.tienda.application.service;

import com.abimportapp.tienda.application.repository.UserRepository;
import com.abimportapp.tienda.domain.Usuario;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Usuario createdUser(Usuario user) {
        return userRepository.createdUser(user);
    }
    public Usuario findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public Usuario findById(Integer id) {
        return userRepository.findById(id);
    }
}
