package com.movieFinder.movieFinderAPI.services.impl;

import com.movieFinder.movieFinderAPI.dtos.PeliculaGeneroDTO;
import com.movieFinder.movieFinderAPI.mappers.PeliculaGeneroMapper;
import com.movieFinder.movieFinderAPI.repositories.PeliculaGeneroRepository;
import com.movieFinder.movieFinderAPI.services.PeliculaGeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Lazy
@Component
public class PeliculaGeneroServiceImpl implements PeliculaGeneroService {
    @Autowired
    private PeliculaGeneroRepository peliculaGeneroRepository;
    //Este método recibe el identificador de la película y los géneros de esa película para almacenarlos en bd
    @Override
    public void insertGenerosPeliculas(int idPelicula, int []idGeneros) {
        for (int idGenero : idGeneros) {
            peliculaGeneroRepository.save(PeliculaGeneroMapper.convertirAModelo(new PeliculaGeneroDTO(0, idPelicula, idGenero)));
        }
    }
}
