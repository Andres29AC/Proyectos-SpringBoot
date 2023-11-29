package com.example.universidadbackend.controlador;

import com.example.universidadbackend.exceptions.BadRequestException;
import com.example.universidadbackend.modelo.entidades.CarreraProfesional;
import com.example.universidadbackend.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carreras")
public class CarreraController {
    private final CarreraDAO carreraDAO;
    //TODO: @Autowired es una anotación que nos permite indicarle a Spring
    //TODO:que esta clase es un componente de Spring y que debe ser
    //TODO:manejado por el contenedor de Spring
    @Autowired
    public CarreraController(CarreraDAO carreraDAO) {
        this.carreraDAO = carreraDAO;
    }
    @GetMapping
    public List<CarreraProfesional> obtenerTodos(){
        List<CarreraProfesional> carreras = (List<CarreraProfesional>) carreraDAO.findAll();
        if (carreras.isEmpty()) {
            throw new BadRequestException("No hay carreras registradas");
        }
        return carreras;
    }
    @GetMapping("/{codigo}")
    public CarreraProfesional obtenerPorId(@PathVariable(value="codigo",required = false) Integer id) {
        Optional<CarreraProfesional> oCarrera = carreraDAO.findById(id);
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
        return carreraDAO.save(carrera);
    }
    @PutMapping("/{id}")
    public CarreraProfesional actualizarCarrera(@PathVariable Integer id,@RequestBody CarreraProfesional carrera){
        CarreraProfesional carreraUpdate = null;
        Optional<CarreraProfesional> oCarrera = carreraDAO.findById(id);
        if(oCarrera.isPresent()){
            throw new BadRequestException("No existe la carrera con id: " + id);
        }
        carreraUpdate = oCarrera.get();
        carreraUpdate.setCantidadAnios(carrera.getCantidadAnios());
        carreraUpdate.setCantidadCursos(carrera.getCantidadCursos());
        return carreraDAO.save(carreraUpdate);
    }
    @DeleteMapping("/{id}")
    public void eliminarCarrera(@PathVariable Integer id){
        carreraDAO.deleteById(id);
    }
}
