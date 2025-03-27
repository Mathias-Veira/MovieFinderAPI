package com.movieFinder.movieFinderAPI.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "PELICULA_GENERO")
public class PeliculaGenero implements Serializable {
    private int idPeliculaGenero;
    private int idPelicula;
    private int idGenero;

    public PeliculaGenero() {
    }

    public PeliculaGenero(int idPeliculaGenero, int idPelicula, int idGenero) {
        this.idPeliculaGenero = idPeliculaGenero;
        this.idPelicula = idPelicula;
        this.idGenero = idGenero;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pelicula_genero")
    public int getIdPeliculaGenero() {
        return idPeliculaGenero;
    }
    @Column(name = "id_pelicula")
    public int getIdPelicula() {
        return idPelicula;
    }
    @Column(name = "id_genero")
    public int getIdGenero() {
        return idGenero;
    }

    public void setIdPeliculaGenero(int idPeliculaGenero) {
        this.idPeliculaGenero = idPeliculaGenero;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }
}
