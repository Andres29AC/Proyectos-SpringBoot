package com.example.universidadbackend.modelo.entidades;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
@Embeddable
public class Direccion implements Serializable {
    private String calle;
    private String numero;
    private String codigoPostal;
    private String dpt;
    private String piso;
    private String localidad;

    public Direccion() {
    }

    public Direccion(String calle, String numero, String codigoPostal, String departamento, String piso, String localidad) {
        this.calle = calle;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
        this.dpt = dpt;
        this.piso = piso;
        this.localidad = localidad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getDepartamento() {
        return dpt;
    }

    public void setDepartamento(String departamento) {
        this.dpt = departamento;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "calle='" + calle + '\'' +
                ", numero='" + numero + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", departamento='" + dpt + '\'' +
                ", piso='" + piso + '\'' +
                ", localidad='" + localidad + '\'' +
                '}';
    }
}
