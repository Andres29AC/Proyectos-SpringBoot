package com.example.universidad.modelo.entidades;

import java.math.BigDecimal;

public class Profesor extends Persona{
  private BigDecimal sueldo;

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
}

