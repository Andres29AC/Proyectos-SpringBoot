package com.example.universidad.modelo.entidades;

public class Alumno extends Persona{
    public Alumno() {
    }

    public Alumno(Integer id, String nombre, String apellido, String dni, String correoElectronico, String telefono, Direccion direccion) {
        super(id, nombre, apellido, dni, correoElectronico, telefono, direccion);
    }
}
