package com.movieFinder.movieFinderAPI.dtos;

import java.time.LocalDate;

public class HistorialPeliculaDTO {
    private int idPelicula;
    private String tituloPelicula;
    private String tituloOriginalPelicula;
    private String sinopsisPelicula;
    private LocalDate fechaSalidaPelicula;
    private String urlPosterPelicula;
    private LocalDate fechaVisto;

    public HistorialPeliculaDTO(){

    }

    public HistorialPeliculaDTO(int idPelicula, String tituloPelicula, String tituloOriginalPelicula, String sinopsisPelicula, LocalDate fechaSalidaPelicula, String urlPosterPelicula, LocalDate fechaVisto) {
        this.idPelicula = idPelicula;
        this.tituloPelicula = tituloPelicula;
        this.tituloOriginalPelicula = tituloOriginalPelicula;
        this.sinopsisPelicula = sinopsisPelicula;
        this.fechaSalidaPelicula = fechaSalidaPelicula;
        this.urlPosterPelicula = urlPosterPelicula;
        this.fechaVisto = fechaVisto;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public String getTituloPelicula() {
        return tituloPelicula;
    }

    public String getTituloOriginalPelicula() {
        return tituloOriginalPelicula;
    }

    public String getSinopsisPelicula() {
        return sinopsisPelicula;
    }

    public LocalDate getFechaSalidaPelicula() {
        return fechaSalidaPelicula;
    }

    public String getUrlPosterPelicula() {
        return urlPosterPelicula;
    }

    public LocalDate getFechaVisto() {
        return fechaVisto;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public void setTituloPelicula(String tituloPelicula) {
        this.tituloPelicula = tituloPelicula;
    }

    public void setTituloOriginalPelicula(String tituloOriginalPelicula) {
        this.tituloOriginalPelicula = tituloOriginalPelicula;
    }

    public void setSinopsisPelicula(String sinopsisPelicula) {
        this.sinopsisPelicula = sinopsisPelicula;
    }

    public void setFechaSalidaPelicula(LocalDate fechaSalidaPelicula) {
        this.fechaSalidaPelicula = fechaSalidaPelicula;
    }

    public void setUrlPosterPelicula(String urlPosterPelicula) {
        this.urlPosterPelicula = urlPosterPelicula;
    }

    public void setFechaVisto(LocalDate fechaVisto) {
        this.fechaVisto = fechaVisto;
    }
}
