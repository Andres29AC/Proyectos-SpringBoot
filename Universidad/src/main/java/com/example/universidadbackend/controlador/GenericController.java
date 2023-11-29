package com.example.universidadbackend.controlador;


import com.example.universidadbackend.exceptions.BadRequestException;
import com.example.universidadbackend.servicios.contratos.GenericoDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class GenericController <E,S extends GenericoDAO<E>> {
    protected final S servicio;
    protected String nombreEntidad;

    public GenericController(S servicio) {
        this.servicio = servicio;
    }
    @GetMapping
    public List<E> obtenerTodos(){
        List<E> listado = (List<E>) servicio.findAll();
        if(listado.isEmpty()){
            throw new BadRequestException(String.format("No hay %s registrados",nombreEntidad));
        }
        return listado;
    }
    //TODO: Obtener por id

}
