package com.example.universidadbackend.servicios.contratos;

import com.example.universidadbackend.modelo.entidades.CarreraProfesional;

import java.util.Optional;

public interface CarreraDAO extends GenericoDAO<CarreraProfesional> {

//    Optional<CarreraProfesional> findById(Integer id);
//    CarreraProfesional save(CarreraProfesional carreraProfesional);
//    Iterable<CarreraProfesional> findAll();
//    void deleteById(Integer id);
    Iterable<CarreraProfesional> findCarrerasByNombreContains(String nombre);
    Iterable<CarreraProfesional> findCarrerasByNombreContainsIgnoreCase(String nombre);
    Iterable<CarreraProfesional> findCarrerasByCantidadAniosAfter(Integer cantidadAnios);
}
//TODO:Optional es una clase que nos permite encapsular
// el famoso null pointer exception y saber si hay presencia
// de datos o no
