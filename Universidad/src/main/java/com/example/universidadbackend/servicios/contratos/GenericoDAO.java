package com.example.universidadbackend.servicios.contratos;
import com.example.universidadbackend.modelo.entidades.CarreraProfesional;
import java.util.Optional;

public interface GenericoDAO<E> {
    Optional<E> findById(Integer id);
    E save(E entidad);
    Iterable<E> findAll();
    void deleteById(Integer id);
}
