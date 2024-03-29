package com.example.universidadbackend.controlador;

import com.example.universidadbackend.exceptions.BadRequestException;
import com.example.universidadbackend.modelo.entidades.Persona;
import com.example.universidadbackend.servicios.contratos.PersonaDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public class PersonaController extends GenericController<Persona, PersonaDAO>{
    public PersonaController(PersonaDAO servicio){
        super(servicio);
    }
    @GetMapping("nombre-apellido")
    public Persona buscarPersonaPorNombreYApellido(@RequestParam String nombre,@RequestParam String apellido){
        Optional<Persona> oPersona = servicio.buscarPorNombreYApellido(nombre,apellido);
        if(!oPersona.isPresent()){
            throw new BadRequestException(String.format("No existe una persona con nombre %s y apellido %s",nombre,apellido));
        }
        return oPersona.get();
    }

}
