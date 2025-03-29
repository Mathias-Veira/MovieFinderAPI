package com.movieFinder.movieFinderAPI.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class ValorarPelicula implements Serializable {
    private int idValorar;
    private int idPelicula;
    private int idUsuario;
    private String nombreUsuario;
    private int valoracion;
    private LocalDate fechaValoracion;
    private String textoValoracion;

    public ValorarPelicula(){

    }

    public ValorarPelicula(int idValorar, int idPelicula, int idUsuario, String nombreUsuario, int valoracion, LocalDate fechaValoracion, String textoValoracion) {
        this.idValorar = idValorar;
        this.idPelicula = idPelicula;
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.valoracion = valoracion;
        this.fechaValoracion = fechaValoracion;
        this.textoValoracion = textoValoracion;
    }
    @Id
    @Column(name = "id_valorar")
    public int getIdValorar() {
        return idValorar;
    }
    @Column(name = "id_pelicula")
    public int getIdPelicula() {
        return idPelicula;
    }
    @Column(name = "id_usuario")
    public int getIdUsuario() {
        return idUsuario;
    }
    @Column(name = "nombre_usuario")
    public String getNombreUsuario() {
        return nombreUsuario;
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

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
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
