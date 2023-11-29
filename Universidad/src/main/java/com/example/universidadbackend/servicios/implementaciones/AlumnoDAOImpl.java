package com.example.universidadbackend.servicios.implementaciones;

import com.example.universidadbackend.modelo.entidades.Persona;
import com.example.universidadbackend.repositorios.AlumnoRepository;
import com.example.universidadbackend.repositorios.PersonaRepository;
import com.example.universidadbackend.servicios.contratos.AlumnoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
public class AlumnoDAOImpl extends PersonaDAOImpl implements AlumnoDAO {
    @Autowired
    public AlumnoDAOImpl(@Qualifier("repositoriosAlumnos")PersonaRepository repository) {
        super(repository);
    }
    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> buscarAlumnosPorNombreCarrera(String nombre){
        return ((AlumnoRepository)repository).buscarAlumnosPorNombreCarrera(nombre);
    }
}
//TODO:@Qualifier es una anotación que nos permite indicarle a Spring
//TODO:que debe inyectar un bean con un nombre en particular





