package com.example.universidadbackend.modelo.entidades;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "alumnos")
@PrimaryKeyJoinColumn(name = "persona_id")
public class Alumno extends Persona{
    @ManyToOne(
            optional = true,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "carrera_id")
    private CarreraProfesional carreraProfesional;
    public Alumno() {
    }

    public Alumno(Integer id, String nombre, String apellido, String dni, String correoElectronico, String telefono, Direccion direccion) {
        super(id, nombre, apellido, dni, correoElectronico, telefono, direccion);
    }

    public CarreraProfesional getCarreraProfesional() {
        return carreraProfesional;
    }

    public void setCarreraProfesional(CarreraProfesional carreraProfesional) {
        this.carreraProfesional = carreraProfesional;
    }



    @Override
    public String toString() {
        return super.toString() +
                "Alumno{}";
    }
}
