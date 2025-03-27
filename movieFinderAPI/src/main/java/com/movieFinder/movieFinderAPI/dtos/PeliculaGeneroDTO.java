package com.movieFinder.movieFinderAPI.dtos;


public class PeliculaGeneroDTO {
    private int idPeliculaGenero;
    private int idPelicula;
    private int idGenero;

    public PeliculaGeneroDTO(){

    }

    public PeliculaGeneroDTO(int idPeliculaGenero, int idPelicula, int idGenero) {
        this.idPeliculaGenero = idPeliculaGenero;
        this.idPelicula = idPelicula;
        this.idGenero = idGenero;
    }

    public int getIdPeliculaGenero() {
        return idPeliculaGenero;
    }

    public void setIdPeliculaGenero(int idPeliculaGenero) {
        this.idPeliculaGenero = idPeliculaGenero;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }
}
