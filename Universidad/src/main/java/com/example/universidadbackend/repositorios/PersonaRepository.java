package com.example.universidadbackend.repositorios;

import com.example.universidadbackend.modelo.entidades.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PersonaRepository extends CrudRepository<Persona, Integer> {

}


//TODO:NoRepositoryBean es una anotación que nos permite
//TODO:indicarle a Spring que esta interfaz no es un repositorio