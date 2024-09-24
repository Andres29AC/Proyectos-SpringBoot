package com.abimportapp.tienda.infrastructure.adapter;

import com.abimportapp.tienda.domain.Usuario;
import com.abimportapp.tienda.infrastructure.entity.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserCrudRepository extends CrudRepository<UsuarioEntity, Integer> {
    Optional<UsuarioEntity> findByEmail (String email);
}
