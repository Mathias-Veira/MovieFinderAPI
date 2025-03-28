package com.movieFinder.movieFinderAPI.dtos;

import java.time.LocalDate;

public class HistorialDTO {
    private int idHistorial;
    private int idUsuario;
    private int idPelicula;
    private LocalDate fechaVisto;

    public HistorialDTO(){

    }

    public HistorialDTO(int idHistorial, int idUsuario, int idPelicula, LocalDate fechaVisto) {
        this.idHistorial = idHistorial;
        this.idUsuario = idUsuario;
        this.idPelicula = idPelicula;
        this.fechaVisto = fechaVisto;
    }

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public LocalDate getFechaVisto() {
        return fechaVisto;
    }

    public void setFechaVisto(LocalDate fechaVisto) {
        this.fechaVisto = fechaVisto;
    }
}
