package com.example.universidadbackend.controlador;

import com.example.universidadbackend.exceptions.BadRequestException;
import com.example.universidadbackend.modelo.entidades.Alumno;
import com.example.universidadbackend.modelo.entidades.CarreraProfesional;
import com.example.universidadbackend.modelo.entidades.Persona;
import com.example.universidadbackend.servicios.contratos.CarreraDAO;
import com.example.universidadbackend.servicios.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.StringTokenizer;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController extends PersonaController{
    private CarreraDAO carreraDao;
    @Autowired
    public AlumnoController(@Qualifier("alumnoDAOImpl") PersonaDAO alumnoDao, CarreraDAO carreraDao) {
        super(alumnoDao);
        nombreEntidad = "Alumno";
        this.carreraDao = carreraDao;
    }
//    @GetMapping
//    public List<Persona> obtenerTodos(){
//        List<Persona> alumnos = (List<Persona>) alumnoDao.findAll();
//        if(alumnos.isEmpty()){
//            throw new BadRequestException("No hay alumnos registrados");
//        }
//        return alumnos;
//    }
//    @GetMapping("/{id}")
//    public Persona obtenerAlumnoPorId(@PathVariable(required = false) Integer id){
//        Optional<Persona> oAlumno = alumnoDao.findById(id);
//        if(oAlumno.isEmpty()){
//            throw new BadRequestException("No existe el alumno con id: " + id);
//        }
//        return oAlumno.get();
//    }
//    @PostMapping
//    public Persona altaAlumno(@RequestBody Persona alumno){
//        return alumnoDao.save(alumno);
//    }
    @PutMapping("/{id}")
    public Persona actualizarAlumno(@PathVariable Integer id,@RequestBody Persona alumno){
        Persona alumnoUpdate = null;
        Optional<Persona> oAlumno = servicio.findById(id);
        if(oAlumno.isPresent()){
            throw new BadRequestException("No existe el alumno con id: " + id);
        }
        alumnoUpdate = oAlumno.get();
        alumnoUpdate.setNombre(alumno.getNombre());
        alumnoUpdate.setApellido(alumno.getApellido());
        alumnoUpdate.setDireccion(alumno.getDireccion());
        alumnoUpdate.setTelefono(alumno.getTelefono());
        alumnoUpdate.setCorreoElectronico(alumno.getCorreoElectronico());
        return servicio.save(alumnoUpdate);
    }
//    @DeleteMapping("/{id}")
//    public void eliminarAlumno(@PathVariable Integer id){
//        alumnoDao.deleteById(id);
//    }
    @PutMapping("/{idAlumno}/carrera/{idCarrera}")
    public Persona asignarCarrera(@PathVariable Integer idAlumno,@PathVariable Integer idCarrera){
        Optional<Persona> oAlumno = servicio.findById(idAlumno);
        if(!oAlumno.isPresent()){
            throw new BadRequestException(String.format("No existe el alumno con id: %d",idAlumno));
        }
        Optional<CarreraProfesional> oCarrera = carreraDao.findById(idCarrera);
        if(!oCarrera.isPresent()){
            throw new BadRequestException(String.format("No existe la carrera con id: %d",idCarrera));
        }
        Persona alumno = oAlumno.get();
        CarreraProfesional carrera = oCarrera.get();
        ((Alumno)alumno).setCarreraProfesional(carrera);
        return servicio.save(alumno);
    }

}
