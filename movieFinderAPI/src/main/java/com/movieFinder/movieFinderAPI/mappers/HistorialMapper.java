package com.movieFinder.movieFinderAPI.mappers;

import com.movieFinder.movieFinderAPI.dtos.HistorialDTO;
import com.movieFinder.movieFinderAPI.models.Historial;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase realiza las conversiones necesarias entre objetos Historial y HistorialDTO
 */
public class HistorialMapper {
    /**
     * Este método permite convertir de modelo a HistorialDTO
     * @param historial objeto de la clase Historial
     * @return objeto de la clase HistorialDTO
     */
    public static HistorialDTO convertirADTO(Historial historial){
        return new HistorialDTO(historial.getIdHistorial(), historial.getIdUsuario(), historial.getIdPelicula(), historial.getFechaVisto());
    }

    /**
     * Este método permite convertir de HistorialDTO a modelo
     * @param historialDTO objeto de la clase HistorialDTO
     * @return objeto de la clase Historial
     */
    public static Historial convertirAModelo(HistorialDTO historialDTO){
        return new Historial(historialDTO.getIdHistorial(), historialDTO.getIdUsuario(), historialDTO.getIdPelicula(), historialDTO.getFechaVisto());
    }

    public static List<HistorialDTO> convertirLista(List<Historial> historialList){
        List<HistorialDTO> historialDTOS = new ArrayList<>();
        for (Historial historial: historialList) {
            historialDTOS.add(convertirADTO(historial));
        }
        return  historialDTOS;
    }
}
