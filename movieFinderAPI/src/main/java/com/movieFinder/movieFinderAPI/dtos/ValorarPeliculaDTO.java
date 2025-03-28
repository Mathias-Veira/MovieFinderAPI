package com.movieFinder.movieFinderAPI.dtos;

import java.time.LocalDate;

public class ValorarPeliculaDTO {
    private int idValorar;
    private int idPelicula;
    private int idUsuario;
    private String nombreUsuario;
    private int valoracion;
    private LocalDate fechaValoracion;
    private String textoValoracion;

    public ValorarPeliculaDTO(){

    }

    public ValorarPeliculaDTO(int idValorar, int idPelicula, int idUsuario, String nombreUsuario, int valoracion, LocalDate fechaValoracion, String textoValoracion) {
        this.idValorar = idValorar;
        this.idPelicula = idPelicula;
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.valoracion = valoracion;
        this.fechaValoracion = fechaValoracion;
        this.textoValoracion = textoValoracion;
    }

    public int getIdValorar() {
        return idValorar;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public int getValoracion() {
        return valoracion;
    }

    public LocalDate getFechaValoracion() {
        return fechaValoracion;
    }

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
