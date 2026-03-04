package com.movieFinder.movieFinderAPI.services;


import com.movieFinder.movieFinderAPI.dtos.PeliculaDTO;
import com.movieFinder.movieFinderAPI.error.IdNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import java.util.List;

public interface PeliculaService {
    void almacenarPeliculas ();
    Page<PeliculaDTO> obtenerPeliculas(Pageable pageable);
    PeliculaDTO obtenerPeliculaById(int idPelicula) throws IdNotFoundException;
    Page<PeliculaDTO> findMoviesByGenreId(int idGenero,Pageable pageable);
    Page<PeliculaDTO> findMoviesByMovieName(String titulo,Pageable pageable);
}
