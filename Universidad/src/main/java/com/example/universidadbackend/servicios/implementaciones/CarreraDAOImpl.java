package com.example.universidadbackend.servicios.implementaciones;

import com.example.universidadbackend.modelo.entidades.CarreraProfesional;
import com.example.universidadbackend.repositorios.CarreraRepository;
import com.example.universidadbackend.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
public class CarreraDAOImpl implements CarreraDAO {
    @Autowired
    private CarreraRepository carreraRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<CarreraProfesional> findById(Integer id) {
        return carreraRepository.findById(id);
    }

    @Override
    @Transactional
    public CarreraProfesional save(CarreraProfesional carreraProfesional) {
        return carreraRepository.save(carreraProfesional);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<CarreraProfesional> findAll() {
        return carreraRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        carreraRepository.deleteById(id);
    }
}
//TODO:@Autowired es una anotación que nos permite inyectar
//TODO:dependencias en nuestro repositorio




