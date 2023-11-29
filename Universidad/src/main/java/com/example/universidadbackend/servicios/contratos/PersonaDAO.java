package com.example.universidadbackend.servicios.contratos;

import com.example.universidadbackend.modelo.entidades.Persona;

import java.util.Optional;

public interface PersonaDAO extends GenericoDAO<Persona> {
//    Optional<Persona> findById(Integer id);
//    Persona save(Persona persona);
//    Iterable<Persona> findAll();
//    void deleteById(Integer id);
    Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido);
    Optional<Persona> buscarPorDni(String dni);
    Iterable<Persona> buscarPersonaPorApellido(String apellido);
}
