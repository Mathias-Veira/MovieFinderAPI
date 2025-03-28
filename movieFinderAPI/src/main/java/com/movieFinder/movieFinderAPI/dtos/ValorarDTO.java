package com.movieFinder.movieFinderAPI.dtos;

import java.time.LocalDate;

public class ValorarDTO {
    private int idValorar;
    private int idUsuario;
    private int idPelicula;
    private int valoracion;
    private LocalDate fechaValoracion;
    private String textoValoracion;
    public ValorarDTO(){

    }

    public ValorarDTO(int idValorar, int idUsuario, int idPelicula, int valoracion, LocalDate fechaValoracion, String textoValoracion) {
        this.idValorar = idValorar;
        this.idUsuario = idUsuario;

        this.idPelicula = idPelicula;
        this.valoracion = valoracion;
        this.fechaValoracion = fechaValoracion;
        this.textoValoracion = textoValoracion;
    }

    public int getIdValorar() {
        return idValorar;
    }

    public int getIdUsuario() {
        return idUsuario;
    }



    public int getIdPelicula() {
        return idPelicula;
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
