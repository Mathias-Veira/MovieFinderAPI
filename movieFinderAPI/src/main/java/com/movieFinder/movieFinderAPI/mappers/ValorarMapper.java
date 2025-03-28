package com.movieFinder.movieFinderAPI.mappers;

import com.movieFinder.movieFinderAPI.dtos.ValorarDTO;
import com.movieFinder.movieFinderAPI.models.Valorar;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase realiza las conversiones necesarias entre objetos Valorar y ValorarDTO
 */
public class ValorarMapper {
    /**
     * Este método permite convertir de modelo a ValorarDTO
     * @param valorar objeto de la clase Valorar
     * @return objeto de la clase ValorarDTO
     */
    public static ValorarDTO convertirADTO(Valorar valorar){
        return new ValorarDTO(valorar.getIdValorar(), valorar.getIdUsuario(),valorar.getIdPelicula(), valorar.getValoracion(), valorar.getFechaValoracion(),valorar.getTextoValoracion());
    }

    /**
     * Este método permite convertir de ValorarDTO a modelo
     * @param valorarDTO objeto de la clase ValorarDTO
     * @return objeto de la clase Valorar
     */
    public static Valorar convertirAModelo(ValorarDTO valorarDTO){
        return new Valorar(valorarDTO.getIdValorar(), valorarDTO.getIdUsuario(), valorarDTO.getIdPelicula(), valorarDTO.getValoracion(), valorarDTO.getFechaValoracion(),valorarDTO.getTextoValoracion());
    }

    public static List<ValorarDTO> convertirLista(List<Valorar> valorarList){
        List<ValorarDTO> valorarDTOS = new ArrayList<>();
        for (Valorar valorar: valorarList) {
            valorarDTOS.add(convertirADTO(valorar));
        }
        return  valorarDTOS;
    }

}
