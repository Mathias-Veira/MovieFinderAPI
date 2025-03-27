package com.movieFinder.movieFinderAPI.services;


import com.movieFinder.movieFinderAPI.dtos.PeliculaDTO;

import java.util.List;

public interface PeliculaService {
    void almacenarPeliculas ();
    List<PeliculaDTO> obtenerPeliculas();
}
