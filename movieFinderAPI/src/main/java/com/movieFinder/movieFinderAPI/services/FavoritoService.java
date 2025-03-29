package com.movieFinder.movieFinderAPI.services;

import com.movieFinder.movieFinderAPI.dtos.FavoritoDTO;
import com.movieFinder.movieFinderAPI.dtos.FavoritoPeliculaDTO;
import com.movieFinder.movieFinderAPI.error.IdNotFoundException;

import java.util.List;

public interface FavoritoService {
    List<FavoritoPeliculaDTO> obtenerListaFavoritos(int idUsuario) throws IdNotFoundException;
    FavoritoDTO guardarPeliFavoritos(int idUsuario,int idPelicula) throws IdNotFoundException;
}
