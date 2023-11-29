package com.example.universidadbackend.modelo.entidades;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "carreras")
public class CarreraProfesional implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true, length = 80)
    private String nombre;
    @Column(name = "cantidad_cursos")
    private Integer cantidadCursos;
    @Column(name = "cantidad_anios")
    private Integer cantidadAnios;
    @Column(name = "fecha_alta")
    private LocalDateTime fechaAlta;
    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;
    @OneToMany(
            mappedBy = "carreraProfesional",
            fetch = FetchType.LAZY
    )
    @JsonIgnoreProperties({"carreraProfesional"})
    private Set<Alumno> alumnos;
    @ManyToMany(
            mappedBy = "carrerasProfesionales",
            fetch = FetchType.LAZY
    )
    @JsonIgnoreProperties({"carrerasProfesionales"})
    private Set<Profesor> profesores;
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

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public Set<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(Set<Profesor> profesores) {
        this.profesores = profesores;
    }

    @PrePersist
    private void antesDePersistir(){
        this.fechaAlta = LocalDateTime.now();
    }
    @PreUpdate
    private void antesDeActualizar(){
        this.fechaModificacion = LocalDateTime.now();
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



