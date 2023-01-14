package com.example.universidad.modelo.entidades;

import com.example.universidad.modelo.entidades.enumeradores.TipoEmpleado;

import java.math.BigDecimal;

public class Empleado extends Persona{
    private BigDecimal sueldo;
    //Utilizaremos enumeraciones para definir los tipos de empleados
    //primero crearemos un package
    private TipoEmpleado tipoEmpleado;

    public Empleado(Integer id, String nombre, String apellido, String dni, String correoElectronico, String telefono, Direccion direccion, BigDecimal sueldo, TipoEmpleado tipoEmpleado) {
        super(id, nombre, apellido, dni, correoElectronico, telefono, direccion);
        this.sueldo = sueldo;
        this.tipoEmpleado = tipoEmpleado;
    }

    public BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }

    public TipoEmpleado getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }
}

