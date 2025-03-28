package com.movieFinder.movieFinderAPI.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "VALORAR")
public class Valorar implements Serializable {
    private int idValorar;
    private int idUsuario;
    private int idPelicula;
    private int valoracion;
    private LocalDate fechaValoracion;
    private String textoValoracion;

    public Valorar(){

    }

    public Valorar(int idValorar, int idUsuario,  int idPelicula, int valoracion, LocalDate fechaValoracion, String textoValoracion) {
        this.idValorar = idValorar;
        this.idUsuario = idUsuario;
        this.idPelicula = idPelicula;
        this.valoracion = valoracion;
        this.fechaValoracion = fechaValoracion;
        this.textoValoracion = textoValoracion;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_valorar")
    public int getIdValorar() {
        return idValorar;
    }
    @Column(name = "id_usuario")
    public int getIdUsuario() {
        return idUsuario;
    }
    @Column(name = "id_pelicula")
    public int getIdPelicula() {
        return idPelicula;
    }
    @Column(name = "valoracion")
    public int getValoracion() {
        return valoracion;
    }
    @Column(name = "fecha_valoracion")
    public LocalDate getFechaValoracion() {
        return fechaValoracion;
    }
    @Column(name = "texto_valoracion")
    public String getTextoValoracion() {
        return textoValoracion;
    }

    public void setIdValorar(int idValorar) {
        this.idValorar = idValorar;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public void setFechaValoracion(LocalDate fechaValoracion) {
        this.fechaValoracion = fechaValoracion;
    }

    public void setTextoValoracion(String textoValoracion) {
        this.textoValoracion = textoValoracion;
    }
}
