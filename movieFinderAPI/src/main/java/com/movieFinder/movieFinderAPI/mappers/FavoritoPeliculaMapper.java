package com.movieFinder.movieFinderAPI.mappers;

import com.movieFinder.movieFinderAPI.dtos.FavoritoPeliculaDTO;
import com.movieFinder.movieFinderAPI.models.FavoritoPelicula;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase realiza las conversiones necesarias entre objetos FavoritoPelicula y FavoritoPeliculaDTO
 */
public class FavoritoPeliculaMapper {
    /**
     * Este método permite convertir de modelo a FavoritoPeliculaDTO
     * @param favorito objeto de la clase FavoritoPelicula
     * @return objeto de la clase FavoritoPeliculaDTO
     */
    public static FavoritoPeliculaDTO convertirADTO(FavoritoPelicula favorito){
        return new FavoritoPeliculaDTO(favorito.getIdFavorito(), favorito.getIdPelicula(), favorito.getTituloPelicula(), favorito.getTituloOriginalPelicula(), favorito.getSinopsisPelicula(), favorito.getFechaSalidaPelicula(),favorito.getUrlPosterPelicula());
    }

    /**
     * Este método permite convertir de FavoritoPeliculaDTO a modelo
     * @param favoritoDTO objeto de la clase FavoritoPeliculaDTO
     * @return objeto de la clase FavoritoPelicula
     */
    public static FavoritoPelicula convertirAModelo(FavoritoPeliculaDTO favoritoDTO){
        return new FavoritoPelicula(favoritoDTO.getIdFavorito(), favoritoDTO.getIdPelicula(), favoritoDTO.getTituloPelicula(), favoritoDTO.getTituloOriginalPelicula(), favoritoDTO.getSinopsisPelicula(), favoritoDTO.getFechaSalidaPelicula(),favoritoDTO.getUrlPosterPelicula());
    }

    public static List<FavoritoPeliculaDTO> convertirLista(List<FavoritoPelicula> favoritoPeliculaList){
        List<FavoritoPeliculaDTO> favoritoPeliculaDTOS = new ArrayList<>();
        for (FavoritoPelicula favoritoPelicula: favoritoPeliculaList) {
            favoritoPeliculaDTOS.add(convertirADTO(favoritoPelicula));
        }
        return  favoritoPeliculaDTOS;
    }
}
