package com.example.universidad.modelo.entidades;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

//Explicacion:Esta clase sirve para crear objetos de tipo pabellon
//implements Serializable sirve para que el objeto se pueda convertir en un flujo de bytes
public class Pabellon implements Serializable {
    private Integer id;
    private String nombre;
    private Direccion direccion;
    private Double  metrosCuadrado;
    private LocalDateTime fechaAlta;
    private LocalDateTime fechaModificacion;

    public Pabellon() {
    }

    public Pabellon(Integer id, String nombre, Direccion direccion, Double metrosCuadrado) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.metrosCuadrado = metrosCuadrado;
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

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Double getMetrosCuadrado() {
        return metrosCuadrado;
    }

    public void setMetrosCuadrado(Double metrosCuadrado) {
        this.metrosCuadrado = metrosCuadrado;
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
        return "Pabellon{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion=" + direccion +
                ", metrosCuadrado=" + metrosCuadrado +
                ", fechaAlta=" + fechaAlta +
                ", fechaModificacion=" + fechaModificacion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pabellon pabellon = (Pabellon) o;
        return id.equals(pabellon.id) && nombre.equals(pabellon.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }
}

