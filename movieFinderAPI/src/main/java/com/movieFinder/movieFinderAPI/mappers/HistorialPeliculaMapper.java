package com.movieFinder.movieFinderAPI.mappers;

import com.movieFinder.movieFinderAPI.dtos.HistorialPeliculaDTO;
import com.movieFinder.movieFinderAPI.models.HistorialPelicula;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase realiza las conversiones necesarias entre objetos HistorialPelicula y HistorialPeliculaDTO
 */
public class HistorialPeliculaMapper {
    /**
     * Este método permite convertir de modelo a HistorialPeliculaDTO
     * @param historial objeto de la clase HistorialPelicula
     * @return objeto de la clase HistorialPeliculaDTO
     */
    public static HistorialPeliculaDTO convertirADTO(HistorialPelicula historial){
        return new HistorialPeliculaDTO(historial.getIdPelicula(), historial.getTituloPelicula(), historial.getTituloOriginalPelicula(), historial.getSinopsisPelicula(), historial.getFechaSalidaPelicula(),historial.getUrlPosterPelicula(),historial.getFechaVisto());
    }

    /**
     * Este método permite convertir de HistorialPeliculaDTO a modelo
     * @param historialDTO objeto de la clase HistorialPeliculaDTO
     * @return objeto de la clase HistorialPelicula
     */
    public static HistorialPelicula convertirAModelo(HistorialPeliculaDTO historialDTO){
        return new HistorialPelicula(historialDTO.getIdPelicula(), historialDTO.getTituloPelicula(), historialDTO.getTituloOriginalPelicula(), historialDTO.getSinopsisPelicula(), historialDTO.getFechaSalidaPelicula(),historialDTO.getUrlPosterPelicula(),historialDTO.getFechaVisto());
    }

    public static List<HistorialPeliculaDTO> convertirLista(List<HistorialPelicula> historialList){
        List<HistorialPeliculaDTO> historialDTOS = new ArrayList<>();
        for (HistorialPelicula historial: historialList) {
            historialDTOS.add(convertirADTO(historial));
        }
        return  historialDTOS;
    }
}
