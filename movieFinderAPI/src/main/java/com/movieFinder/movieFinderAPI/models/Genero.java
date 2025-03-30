package com.movieFinder.movieFinderAPI.models;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "GENERO")
public class Genero implements Serializable {
    private int idGenero;
    private String nombreGenero;

    public Genero(){

    }

    public Genero(int idGenero, String nombreGenero) {
        this.idGenero = idGenero;
        this.nombreGenero = nombreGenero;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_genero")
    public int getIdGenero() {
        return idGenero;
    }
    @Column(name = "nombre_genero")
    public String getNombreGenero() {
        return nombreGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public void setNombreGenero(String nombreGenero) {
        this.nombreGenero = nombreGenero;
    }
}
