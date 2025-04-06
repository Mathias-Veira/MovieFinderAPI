package com.movieFinder.movieFinderAPI.mappers;

import com.movieFinder.movieFinderAPI.dtos.PeliculaDTO;
import com.movieFinder.movieFinderAPI.models.Pelicula;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase realiza las conversiones necesarias entre objetos Pelicula y PeliculaDTO
 */
public class PeliculaMapper {
    /**
     * Este método permite convertir de modelo a PeliculaDTO
     * @param pelicula objeto de la clase Pelicula
     * @return objeto de la clase PeliculaDTO
     */
    public static PeliculaDTO convertirADTO(Pelicula pelicula){
        return new PeliculaDTO(pelicula.getIdPelicula(), pelicula.getTituloPelicula(), pelicula.getTituloOriginalPelicula(), pelicula.getSinopsisPelicula(), pelicula.getFechaSalidaPelicula(), pelicula.getUrlPosterPelicula());
    }

    /**
     * Este método permite convertir de PeliculaDTO a modelo
     * @param peliculaDTO objeto de la clase PeliculaDTO
     * @return objeto de la clase Pelicula
     */
    public static Pelicula convertirAModelo(PeliculaDTO peliculaDTO){
        return new Pelicula(peliculaDTO.getIdPelicula(), peliculaDTO.getTituloPelicula(), peliculaDTO.getTituloOriginalPelicula(), peliculaDTO.getSinopsisPelicula(), peliculaDTO.getFechaSalidaPelicula(), peliculaDTO.getUrlPosterPelicula());
    }

    public static List<PeliculaDTO> convertirLista(List<Pelicula> pelis){
        List<PeliculaDTO> peliculaDTOS = new ArrayList<>();

        for (Pelicula pelicula: pelis) {
            peliculaDTOS.add(convertirADTO(pelicula));
        }

        return  peliculaDTOS;
    }

    public static Page<PeliculaDTO> convertirPagina(Page<Pelicula> pagePelis) {
        List<PeliculaDTO> peliculaDTOS = new ArrayList<>();
        for (Pelicula pelicula : pagePelis.getContent()) {
            peliculaDTOS.add(convertirADTO(pelicula));
        }

        Pageable pageable = pagePelis.getPageable();
        return new PageImpl<>(peliculaDTOS, pageable, pagePelis.getTotalElements());
    }


}
