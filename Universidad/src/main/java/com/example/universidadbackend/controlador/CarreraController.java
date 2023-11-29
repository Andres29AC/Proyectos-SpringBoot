package com.example.universidadbackend.controlador;

import com.example.universidadbackend.exceptions.BadRequestException;
import com.example.universidadbackend.modelo.entidades.CarreraProfesional;
import com.example.universidadbackend.servicios.contratos.CarreraDAO;
import com.example.universidadbackend.servicios.implementaciones.CarreraDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carreras")
public class CarreraController extends GenericController<CarreraProfesional, CarreraDAO> {

    //TODO: @Autowired es una anotación que nos permite indicarle a Spring
    //TODO:que esta clase es un componente de Spring y que debe ser
    //TODO:manejado por el contenedor de Spring
    @Autowired
    public CarreraController(CarreraDAO servicio) {
        super(servicio);
        nombreEntidad = "Carrera";
    }
    @GetMapping("/{codigo}")
    public CarreraProfesional obtenerPorId(@PathVariable(value="codigo",required = false) Integer id) {
        Optional<CarreraProfesional> oCarrera = servicio.findById(id);
        if (oCarrera.isEmpty()) {
            throw new BadRequestException("No existe la carrera con id: " + id);
        }
        return oCarrera.get();
    }
    @PostMapping
    public CarreraProfesional altaCarrera(@RequestBody CarreraProfesional carrera) {
        if(carrera.getCantidadAnios()< 0){
            throw new BadRequestException("La cantidad de años no puede ser negativa");
        }
        if(carrera.getCantidadCursos()< 0){
            throw new BadRequestException("La cantidad de cursos no puede ser negativa");
        }
        return servicio.save(carrera);
    }
    @PutMapping("/{id}")
    public CarreraProfesional actualizarCarrera(@PathVariable Integer id,@RequestBody CarreraProfesional carrera){
        CarreraProfesional carreraUpdate = null;
        Optional<CarreraProfesional> oCarrera = servicio.findById(id);
        if(oCarrera.isPresent()){
            throw new BadRequestException("No existe la carrera con id: " + id);
        }
        carreraUpdate = oCarrera.get();
        carreraUpdate.setCantidadAnios(carrera.getCantidadAnios());
        carreraUpdate.setCantidadCursos(carrera.getCantidadCursos());
        return servicio.save(carreraUpdate);
    }
    @DeleteMapping("/{id}")
    public void eliminarCarrera(@PathVariable Integer id){
        servicio.deleteById(id);
    }
}
