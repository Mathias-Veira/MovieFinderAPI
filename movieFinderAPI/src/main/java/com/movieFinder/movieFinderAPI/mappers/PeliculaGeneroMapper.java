package com.movieFinder.movieFinderAPI.mappers;


import com.movieFinder.movieFinderAPI.dtos.PeliculaGeneroDTO;
import com.movieFinder.movieFinderAPI.models.PeliculaGenero;

/**
 * Esta clase realiza las conversiones necesarias entre objetos PeliculaGenero y PeliculaGeneroDTO
 */
public class PeliculaGeneroMapper {
    /**
     * Este método permite convertir de modelo a PeliculaGeneroDTO
     * @param peliculaGenero objeto de la clase PeliculaGenero
     * @return objeto de la clase PeliculaDTO
     */
    public static PeliculaGeneroDTO convertirADTO(PeliculaGenero peliculaGenero){
        return new PeliculaGeneroDTO(peliculaGenero.getIdPeliculaGenero(), peliculaGenero.getIdPelicula(), peliculaGenero.getIdGenero());
    }

    /**
     * Este método permite convertir de PeliculaGeneroDTO a modelo
     * @param peliculaGeneroDTO objeto de la clase PeliculaGeneroDTO
     * @return objeto de la clase PeliculaGenero
     */
    public static PeliculaGenero convertirAModelo(PeliculaGeneroDTO peliculaGeneroDTO){
        return new PeliculaGenero(peliculaGeneroDTO.getIdPeliculaGenero(), peliculaGeneroDTO.getIdPelicula(), peliculaGeneroDTO.getIdGenero());
    }
}
