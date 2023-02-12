package com.example.universidadbackend.servicios.implementaciones;

import com.example.universidadbackend.modelo.entidades.Persona;
import com.example.universidadbackend.repositorios.PersonaRepository;
import com.example.universidadbackend.servicios.contratos.AlumnoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
public class AlumnoDAOImpl implements AlumnoDAO {
    @Autowired
    @Qualifier("repositoriosAlumnos")
    //Aqui le decimos que nos inyecte un bean de repositoriosAlumnos
    //que es el que creamos en la interfaz AlumnoRepository
    private PersonaRepository repository;
    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> findById(Integer id) {
        return repository.findById(id);
    }
    @Override
    @Transactional
    public Persona save(Persona persona) {
        return repository.save(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
//TODO:@Qualifier es una anotación que nos permite indicarle a Spring
//TODO:que debe inyectar un bean con un nombre en particular





