package com.example.universidad.modelo.entidades;

import com.example.universidad.modelo.entidades.enumeradores.TipoPizarra;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
@Entity
@Table(name = "aulas")
public class Aula implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "numero_aula", nullable = false)
    private Integer numAula;
    @Column(name = "medidas_aula")
    private String medidas;
    @Column(name = "caantidad_carpetas")
    private Integer cantidadCarpetas;
    @Column(name = "tipo_pizarra")
    @Enumerated(EnumType.STRING)
    private TipoPizarra tipoPizarra;
    @Column(name = "fecha_alta")
    private LocalDateTime fechaAlta;
    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;
    @JoinColumn(
            name ="pabellon_id",
            foreignKey = @ForeignKey(
                    name = "FK_PAPELLON_ID"
            )
    )
    private Pabellon pabellon;

    public Aula() {
    }

    public Aula(Integer id, Integer numAula, String medidas, Integer cantidadCarpetas, TipoPizarra tipoPizarra) {
        this.id = id;
        this.numAula = numAula;
        this.medidas = medidas;
        this.cantidadCarpetas = cantidadCarpetas;
        this.tipoPizarra = tipoPizarra;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumAula() {
        return numAula;
    }

    public void setNumAula(Integer numAula) {
        this.numAula = numAula;
    }

    public String getMedidas() {
        return medidas;
    }

    public void setMedidas(String medidas) {
        this.medidas = medidas;
    }

    public Integer getCantidadCarpetas() {
        return cantidadCarpetas;
    }

    public void setCantidadCarpetas(Integer cantidadCarpetas) {
        this.cantidadCarpetas = cantidadCarpetas;
    }

    public TipoPizarra getTipoPizarra() {
        return tipoPizarra;
    }

    public void setTipoPizarra(TipoPizarra tipoPizarra) {
        this.tipoPizarra = tipoPizarra;
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

    public Pabellon getPabellon() {
        return pabellon;
    }

    public void setPabellon(Pabellon pabellon) {
        this.pabellon = pabellon;
    }

    @Override
    public String toString() {
        return "Aula{" +
                "id=" + id +
                ", numAula=" + numAula +
                ", medidas='" + medidas + '\'' +
                ", cantidadCarpetas=" + cantidadCarpetas +
                ", tipoPizarra=" + tipoPizarra +
                ", fechaAlta=" + fechaAlta +
                ", fechaModificacion=" + fechaModificacion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aula aula = (Aula) o;
        return id.equals(aula.id) && numAula.equals(aula.numAula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numAula);
    }
}
