package com.movieFinder.movieFinderAPI.services;

import com.movieFinder.movieFinderAPI.dtos.FavoritoDTO;
import com.movieFinder.movieFinderAPI.dtos.FavoritoPeliculaDTO;
import com.movieFinder.movieFinderAPI.dtos.HistorialDTO;
import com.movieFinder.movieFinderAPI.error.IdNotFoundException;

import java.util.List;

public interface FavoritoService {
    List<FavoritoPeliculaDTO> obtenerListaFavoritos(int idUsuario) throws IdNotFoundException;
    FavoritoDTO guardarPeliFavoritos(int idUsuario,int idPelicula) throws IdNotFoundException;
    void borrarPeliFavoritos(int idUsuario,int idPelicula) throws IdNotFoundException;
    FavoritoDTO obtenerPeliculaFavorito(int idUsuario, int idPelicula) throws IdNotFoundException;
}
