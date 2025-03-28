package com.movieFinder.movieFinderAPI.services;

import com.movieFinder.movieFinderAPI.dtos.ValorarPeliculaDTO;
import com.movieFinder.movieFinderAPI.error.IdNotFoundException;



import java.util.List;

public interface ValorarService {
    List<ValorarPeliculaDTO> obtenerValoracionesPelis(int idPelicula) throws IdNotFoundException;
}
