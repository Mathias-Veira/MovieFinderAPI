package com.movieFinder.movieFinderAPI.dtos;

import com.movieFinder.movieFinderAPI.models.FavoritoPelicula;

import java.time.LocalDate;

public class FavoritoPeliculaDTO {
    private int idFavorito;
    private int idPelicula;
    private String tituloPelicula;
    private String tituloOriginalPelicula;
    private String sinopsisPelicula;
    private LocalDate fechaSalidaPelicula;
    private String urlPosterPelicula;

    public FavoritoPeliculaDTO(){

    }

    public FavoritoPeliculaDTO(int idFavorito, int idPelicula, String tituloPelicula, String tituloOriginalPelicula, String sinopsisPelicula, LocalDate fechaSalidaPelicula, String urlPosterPelicula) {
        this.idFavorito = idFavorito;
        this.idPelicula = idPelicula;
        this.tituloPelicula = tituloPelicula;
        this.tituloOriginalPelicula = tituloOriginalPelicula;
        this.sinopsisPelicula = sinopsisPelicula;
        this.fechaSalidaPelicula = fechaSalidaPelicula;
        this.urlPosterPelicula = urlPosterPelicula;
    }

    public int getIdFavorito() {
        return idFavorito;
    }

    public void setIdFavorito(int idFavorito) {
        this.idFavorito = idFavorito;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTituloPelicula() {
        return tituloPelicula;
    }

    public void setTituloPelicula(String tituloPelicula) {
        this.tituloPelicula = tituloPelicula;
    }

    public String getTituloOriginalPelicula() {
        return tituloOriginalPelicula;
    }

    public void setTituloOriginalPelicula(String tituloOriginalPelicula) {
        this.tituloOriginalPelicula = tituloOriginalPelicula;
    }

    public String getSinopsisPelicula() {
        return sinopsisPelicula;
    }

    public void setSinopsisPelicula(String sinopsisPelicula) {
        this.sinopsisPelicula = sinopsisPelicula;
    }

    public LocalDate getFechaSalidaPelicula() {
        return fechaSalidaPelicula;
    }

    public void setFechaSalidaPelicula(LocalDate fechaSalidaPelicula) {
        this.fechaSalidaPelicula = fechaSalidaPelicula;
    }

    public String getUrlPosterPelicula() {
        return urlPosterPelicula;
    }

    public void setUrlPosterPelicula(String urlPosterPelicula) {
        this.urlPosterPelicula = urlPosterPelicula;
    }

}
