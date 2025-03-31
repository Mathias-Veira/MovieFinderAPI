package com.movieFinder.movieFinderAPI.services;

import com.movieFinder.movieFinderAPI.dtos.GeneroDTO;
import com.movieFinder.movieFinderAPI.error.IdNotFoundException;

import java.util.List;

public interface GeneroService {
    List<GeneroDTO> obtenerGeneros();
    List<GeneroDTO> obtenerGenerosByMovieId(int idPelicula) throws IdNotFoundException;
}
