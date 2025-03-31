package com.movieFinder.movieFinderAPI.services.impl;

import com.movieFinder.movieFinderAPI.dtos.GeneroDTO;
import com.movieFinder.movieFinderAPI.error.IdNotFoundException;
import com.movieFinder.movieFinderAPI.mappers.GeneroMapper;
import com.movieFinder.movieFinderAPI.repositories.GeneroRepository;
import com.movieFinder.movieFinderAPI.repositories.PeliculaRepository;
import com.movieFinder.movieFinderAPI.services.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Lazy
@Component
public class GeneroServiceImpl implements GeneroService {
    @Autowired
    private GeneroRepository generoRepository;
    @Autowired
    private PeliculaRepository peliculaRepository;
    @Override
    public List<GeneroDTO> obtenerGeneros() {
        return GeneroMapper.convertirLista(generoRepository.findAll());
    }

    @Override
    public List<GeneroDTO> obtenerGeneros(int idPelicula) throws IdNotFoundException {
        if(!peliculaRepository.existsById(idPelicula)){
            throw new IdNotFoundException("La película no existe");
        }
        return GeneroMapper.convertirLista(generoRepository.obtenerGeneros(idPelicula));
    }
}
