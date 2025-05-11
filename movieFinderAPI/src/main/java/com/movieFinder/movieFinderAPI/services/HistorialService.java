package com.movieFinder.movieFinderAPI.services;

import com.movieFinder.movieFinderAPI.dtos.HistorialDTO;
import com.movieFinder.movieFinderAPI.error.IdNotFoundException;
import com.movieFinder.movieFinderAPI.dtos.HistorialPeliculaDTO;

import java.time.LocalDate;
import java.util.List;

public interface HistorialService {
    List<HistorialPeliculaDTO> obtenerHistorialPelicula(int idUsuario) throws IdNotFoundException;
    HistorialDTO guardarPeliHistorial(int idUsuario,int idPelicula) throws IdNotFoundException;
    void borrarPeliHistorial(int idUsuario, int idPelicula) throws IdNotFoundException;
    HistorialDTO obtenerPeliculaHistorial(int idUsuario,int idPelicula) throws IdNotFoundException;
}
