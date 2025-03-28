package com.movieFinder.movieFinderAPI.mappers;

import com.movieFinder.movieFinderAPI.dtos.ValorarPeliculaDTO;
import com.movieFinder.movieFinderAPI.models.ValorarPelicula;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase realiza las conversiones necesarias entre objetos ValorarPelicula y ValorarPeliculaDTO
 */
public class ValorarPeliculaMapper {
    /**
     * Este método permite convertir de modelo a ValorarPeliculaDTO
     * @param valorar objeto de la clase ValorarPelicula
     * @return objeto de la clase ValorarPeliculaDTO
     */
    public static ValorarPeliculaDTO convertirADTO(ValorarPelicula valorar){
        return new ValorarPeliculaDTO(valorar.getIdValorar(),valorar.getIdPelicula(), valorar.getIdUsuario(), valorar.getNombreUsuario(), valorar.getValoracion(), valorar.getFechaValoracion(),valorar.getTextoValoracion());
    }

    /**
     * Este método permite convertir de ValorarPeliculaDTO a modelo
     * @param valorarDTO objeto de la clase ValorarPeliculaDTO
     * @return objeto de la clase ValorarPelicula
     */
    public static ValorarPelicula convertirAModelo(ValorarPeliculaDTO valorarDTO){
        return new ValorarPelicula(valorarDTO.getIdValorar(),valorarDTO.getIdPelicula(), valorarDTO.getIdUsuario(), valorarDTO.getNombreUsuario(), valorarDTO.getValoracion(), valorarDTO.getFechaValoracion(),valorarDTO.getTextoValoracion());
    }

    public static List<ValorarPeliculaDTO> convertirLista(List<ValorarPelicula> valorarList){
        List<ValorarPeliculaDTO> valorarDTOS = new ArrayList<>();
        for (ValorarPelicula valorar: valorarList) {
            valorarDTOS.add(convertirADTO(valorar));
        }
        return  valorarDTOS;
    }
}
