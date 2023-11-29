package com.example.universidadbackend.repositorios;

import com.example.universidadbackend.modelo.entidades.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("repositoriosAlumnos")
public interface AlumnoRepository extends PersonaRepository{
    @Query("SELECT a FROM Alumno a JOIN fetch a.carreraProfesional c WHERE c.nombre = ?1")
    Iterable<Persona> buscarAlumnosPorNombreCarrera(String nombre);
}


