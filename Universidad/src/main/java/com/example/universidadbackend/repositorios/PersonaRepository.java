package com.example.universidadbackend.repositorios;

import com.example.universidadbackend.modelo.entidades.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface PersonaRepository extends CrudRepository<Persona, Integer> {
    @Query("SELECT p FROM Persona p WHERE p.nombre = ?1 AND p.apellido = ?2")
    Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido);
    @Query("SELECT p FROM Persona p WHERE p.dni = ?1")
    Optional<Persona> buscarPorDni(String dni);
    @Query("SELECT p FROM Persona p WHERE p.apellido like %?1%")
    Iterable<Persona> buscarPersonaPorApellido(String apellido);
}


//TODO:NoRepositoryBean es una anotación que nos permite
//TODO:indicarle a Spring que esta interfaz no es un repositorio