package com.example.universidadbackend.repositorios;

import com.example.universidadbackend.modelo.entidades.CarreraProfesional;
import org.springframework.data.repository.CrudRepository;


//Usando Spring Data JPA
public interface CarreraRepository extends CrudRepository<CarreraProfesional, Integer>{
    Iterable<CarreraProfesional> findCarrerasByNombreContains(String nombre);
    Iterable<CarreraProfesional> findCarrerasByNombreContainsIgnoreCase(String nombre);
    Iterable<CarreraProfesional> findCarrerasByCantidadAniosAfter(Integer cantidadAnios);
}

//TODO:Este repositorio debe extender de uno de los tres
//TODO:repositorios que nos provee Spring Data JPA que son
//TODO:CrudRepository, PagingAndSortingRepository y JpaRepository
//TODO:PagingAndSortingRepository extiende de CrudRepository
//TODO:JpaRepository extiende de PagingAndSortingRepository
