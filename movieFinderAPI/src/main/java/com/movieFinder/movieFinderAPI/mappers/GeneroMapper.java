package com.movieFinder.movieFinderAPI.mappers;

import com.movieFinder.movieFinderAPI.dtos.GeneroDTO;
import com.movieFinder.movieFinderAPI.models.Genero;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase realiza las conversiones necesarias entre objetos Genero y GeneroDTO
 */
public class GeneroMapper {
    /**
     * Este método permite convertir de modelo a GeneroDTO
     * @param genero objeto de la clase Genero
     * @return objeto de la clase GeneroDTO
     */
    public static GeneroDTO convertirADTO(Genero genero){
        return new GeneroDTO(genero.getIdGenero(), genero.getNombreGenero());
    }

    /**
     * Este método permite convertir de GeneroDTO a modelo
     * @param generoDTO objeto de la clase GeneroDTO
     * @return objeto de la clase Genero
     */
    public static Genero convertirAModelo(GeneroDTO generoDTO){
        return new Genero(generoDTO.getIdGenero(), generoDTO.getNombreGenero());
    }

    public static List<GeneroDTO> convertirLista(List<Genero> generos){
        List<GeneroDTO> generoDTOS = new ArrayList<>();

        for (Genero genero: generos) {
            generoDTOS.add(convertirADTO(genero));
        }

        return  generoDTOS;
    }
}
