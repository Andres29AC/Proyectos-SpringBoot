package com.abimportapp.tienda.application.repository;

import com.abimportapp.tienda.domain.Usuario;

public interface UserRepository {
    public Usuario createdUser(Usuario user);
    public Usuario findByEmail(String email);
    public Usuario findById(Integer id);
}
