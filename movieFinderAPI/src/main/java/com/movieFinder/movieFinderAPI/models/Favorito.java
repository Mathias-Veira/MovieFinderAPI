package com.movieFinder.movieFinderAPI.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "FAVORITO")
public class Favorito implements Serializable {
    private int idFavorito;
    private int idUsuario;
    private int idPelicula;

    public Favorito(){

    }

    public Favorito(int idFavorito, int idUsuario, int idPelicula) {
        this.idFavorito = idFavorito;
        this.idUsuario = idUsuario;
        this.idPelicula = idPelicula;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_favorito")
    public int getIdFavorito() {
        return idFavorito;
    }
    @Column(name = "id_usuario")
    public int getIdUsuario() {
        return idUsuario;
    }
    @Column(name = "id_pelicula")
    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdFavorito(int idFavorito) {
        this.idFavorito = idFavorito;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }
}
