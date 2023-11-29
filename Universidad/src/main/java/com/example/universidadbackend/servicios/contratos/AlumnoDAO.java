package com.example.universidadbackend.servicios.contratos;


import com.example.universidadbackend.modelo.entidades.Persona;

public interface AlumnoDAO extends PersonaDAO{
    Iterable<Persona> buscarAlumnosPorNombreCarrera(String nombre);

}

