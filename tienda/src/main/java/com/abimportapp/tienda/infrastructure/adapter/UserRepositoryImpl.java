package com.abimportapp.tienda.infrastructure.adapter;

import com.abimportapp.tienda.application.repository.UserRepository;
import com.abimportapp.tienda.domain.Usuario;
import com.abimportapp.tienda.infrastructure.mapper.UsuarioMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final UserCrudRepository userCrudRepository;
    private final UsuarioMapper userMapper;

    public UserRepositoryImpl(UserCrudRepository userCrudRepository, UsuarioMapper userMapper) {
        this.userCrudRepository = userCrudRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Usuario createdUser(Usuario user) {
        return userMapper.toUser(userCrudRepository.save(userMapper.toUserEntity(user)));
    }

    @Override
    public Usuario findByEmail(String email) {
        return userMapper.toUser(userCrudRepository.findByEmail(email).get());
    }

    @Override
    public Usuario findById(Integer id) {
        return userMapper.toUser(userCrudRepository.findById(id).get());
    }
}
