package com.movieFinder.movieFinderAPI.services;


import com.movieFinder.movieFinderAPI.dtos.PeliculaDTO;
import com.movieFinder.movieFinderAPI.error.IdNotFoundException;

import java.util.List;

public interface PeliculaService {
    void almacenarPeliculas ();
    List<PeliculaDTO> obtenerPeliculas();
    PeliculaDTO obtenerPeliculaById(int idPelicula) throws IdNotFoundException;
}
