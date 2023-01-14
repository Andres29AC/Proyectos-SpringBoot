package com.example.universidad.modelo.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class CarreraProfesional implements Serializable {
    private Integer id;
    private String nombre;
    private Integer cantidadCursos;
    private Integer cantidadAnios;
    private LocalDateTime fechaAlta;
    private LocalDateTime fechaModificacion;

    public CarreraProfesional() {
    }

    public CarreraProfesional(Integer id, String nombre, Integer cantidadCursos, Integer cantidadAnios) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadCursos = cantidadCursos;
        this.cantidadAnios = cantidadAnios;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadCursos() {
        return cantidadCursos;
    }

    public void setCantidadCursos(Integer cantidadCursos) {
        this.cantidadCursos = cantidadCursos;
    }

    public Integer getCantidadAnios() {
        return cantidadAnios;
    }

    public void setCantidadAnios(Integer cantidadAnios) {
        this.cantidadAnios = cantidadAnios;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @Override
    public String toString() {
        return "CarreraProfesional{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cantidadCursos=" + cantidadCursos +
                ", cantidadAnios=" + cantidadAnios +
                ", fechaAlta=" + fechaAlta +
                ", fechaModificacion=" + fechaModificacion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarreraProfesional that = (CarreraProfesional) o;
        return id.equals(that.id) && nombre.equals(that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }
}



