package com.example.universidadbackend.modelo.entidades;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "profesores")
@PrimaryKeyJoinColumn(name = "persona_id")
public class Profesor extends Persona{
    private BigDecimal sueldo;
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }

    )
    @JoinTable(
            name = "profesor_carrera",
            joinColumns = @JoinColumn(name = "profesor_id"),
            inverseJoinColumns = @JoinColumn(name = "carrera_id")
    )
    private Set<CarreraProfesional> carrerasProfesionales;



    public Profesor() {
    }

    public Profesor(Integer id, String nombre, String apellido, String dni, String correoElectronico, String telefono, Direccion direccion, BigDecimal sueldo) {
        super(id, nombre, apellido, dni, correoElectronico, telefono, direccion);
        this.sueldo = sueldo;
    }

    public BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }
    public Set<CarreraProfesional> getCarrerasProfesionales() {
        return carrerasProfesionales;
    }

    public void setCarrerasProfesionales(Set<CarreraProfesional> carrerasProfesionales) {
        this.carrerasProfesionales = carrerasProfesionales;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\tProfesor{" +
                "sueldo=" + sueldo +
                '}';
    }
}


