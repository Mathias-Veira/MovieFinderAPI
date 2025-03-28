package com.movieFinder.movieFinderAPI.mappers;

import com.movieFinder.movieFinderAPI.dtos.FavoritoDTO;
import com.movieFinder.movieFinderAPI.models.Favorito;

import java.util.ArrayList;
import java.util.List;


/**
 * Esta clase realiza las conversiones necesarias entre objetos Favorito y FavoritoDTO
 */
public class FavoritoMapper {
    /**
     * Este método permite convertir de modelo a FavoritoDTO
     * @param favorito objeto de la clase Favorito
     * @return objeto de la clase FavoritoDTO
     */
    public static FavoritoDTO convertirADTO(Favorito favorito){
        return new FavoritoDTO(favorito.getIdFavorito(), favorito.getIdUsuario(), favorito.getIdPelicula());
    }

    /**
     * Este método permite convertir de FavoritoDTO a modelo
     * @param favoritoDTO objeto de la clase FavoritoDTO
     * @return objeto de la clase Favorito
     */
    public static Favorito convertirAModelo(FavoritoDTO favoritoDTO){
        return new Favorito(favoritoDTO.getIdFavorito(), favoritoDTO.getIdUsuario(), favoritoDTO.getIdPelicula());
    }

    public static List<FavoritoDTO> convertirLista(List<Favorito> favoritos){
        List<FavoritoDTO> favoritoDTOS = new ArrayList<>();

        for (Favorito favorito: favoritos) {
            favoritoDTOS.add(convertirADTO(favorito));
        }

        return  favoritoDTOS;
    }
}
