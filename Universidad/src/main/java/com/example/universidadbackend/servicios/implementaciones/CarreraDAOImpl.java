package com.example.universidadbackend.servicios.implementaciones;

import com.example.universidadbackend.modelo.entidades.CarreraProfesional;
import com.example.universidadbackend.repositorios.CarreraRepository;
import com.example.universidadbackend.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
public class CarreraDAOImpl extends GenericoDAOImpl<CarreraProfesional,CarreraRepository> implements CarreraDAO {
    @Autowired
    public CarreraDAOImpl(CarreraRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<CarreraProfesional> findCarrerasByNombreContains(String nombre) {
        return repository.findCarrerasByNombreContains(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<CarreraProfesional> findCarrerasByNombreContainsIgnoreCase(String nombre) {
        return repository.findCarrerasByNombreContainsIgnoreCase(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<CarreraProfesional> findCarrerasByCantidadAniosAfter(Integer cantidadAnios) {
        return repository.findCarrerasByCantidadAniosAfter(cantidadAnios);
    }
}
//TODO:@Autowired es una anotación que nos permite inyectar
//TODO:dependencias en nuestro repositorio




