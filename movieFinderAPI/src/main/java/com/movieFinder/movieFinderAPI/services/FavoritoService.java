package com.movieFinder.movieFinderAPI.services;

import com.movieFinder.movieFinderAPI.dtos.FavoritoDTO;
import com.movieFinder.movieFinderAPI.error.IdNotFoundException;

import java.util.List;

public interface FavoritoService {
    List<FavoritoDTO> obtenerListaFavoritos(int idUsuario) throws IdNotFoundException;
}
