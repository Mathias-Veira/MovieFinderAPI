package com.movieFinder.movieFinderAPI.dtos;

public class FavoritoDTO {
    private int idFavorito;
    private int idUsuario;
    private int idPelicula;
    public FavoritoDTO(){

    }

    public FavoritoDTO(int idFavorito, int idUsuario, int idPelicula) {
        this.idFavorito = idFavorito;
        this.idUsuario = idUsuario;
        this.idPelicula = idPelicula;
    }

    public int getIdFavorito() {
        return idFavorito;
    }

    public void setIdFavorito(int idFavorito) {
        this.idFavorito = idFavorito;
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
}
