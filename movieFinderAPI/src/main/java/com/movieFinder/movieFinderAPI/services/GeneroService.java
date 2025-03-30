package com.movieFinder.movieFinderAPI.services;

import com.movieFinder.movieFinderAPI.dtos.GeneroDTO;

import java.util.List;

public interface GeneroService {
    List<GeneroDTO> obtenerGeneros();
}
