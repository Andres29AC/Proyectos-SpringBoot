package com.example.universidadbackend.modelo.entidades;

import com.example.universidadbackend.modelo.entidades.enumeradores.TipoEmpleado;
import jakarta.persistence.*;

import java.math.BigDecimal;
@Entity
@Table(name = "empleados")
@PrimaryKeyJoinColumn(name = "persona_id")
public class Empleado extends Persona{
    private BigDecimal sueldo;
    //Utilizaremos enumeraciones para definir los tipos de empleados
    //primero crearemos un package
    @Column(name = "tipo_empleado")
    @Enumerated(EnumType.STRING)
    private TipoEmpleado tipoEmpleado;
    @OneToOne(
            optional = true,
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "pabellon_id",
            foreignKey = @ForeignKey(
                    name = "FK_PABELLON_ID"
            )
    )
    private Pabellon pabellon;
    public Empleado() {
    }
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

    public Pabellon getPabellon() {
        return pabellon;
    }

    public void setPabellon(Pabellon pabellon) {
        this.pabellon = pabellon;
    }


    @Override
    public String toString() {
        return super.toString() + "\tEmpleado{" +
                "sueldo=" + sueldo +
                ", tipoEmpleado=" + tipoEmpleado +
                '}';
    }
}

