package com.example.universidadbackend.servicios.contratos;

import com.example.universidadbackend.modelo.entidades.CarreraProfesional;

import java.util.Optional;

public interface CarreraDAO {

    Optional<CarreraProfesional> findById(Integer id);
    CarreraProfesional save(CarreraProfesional carreraProfesional);
    Iterable<CarreraProfesional> findAll();
    void deleteById(Integer id);
}
//TODO:Optional es una clase que nos permite encapsular
// el famoso null pointer exception y saber si hay presencia
// de datos o no
