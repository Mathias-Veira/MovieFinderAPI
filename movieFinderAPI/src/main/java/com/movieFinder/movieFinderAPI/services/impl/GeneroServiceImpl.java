package com.movieFinder.movieFinderAPI.services.impl;

import com.movieFinder.movieFinderAPI.dtos.GeneroDTO;
import com.movieFinder.movieFinderAPI.mappers.GeneroMapper;
import com.movieFinder.movieFinderAPI.repositories.GeneroRepository;
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
    @Override
    public List<GeneroDTO> obtenerGeneros() {
        return GeneroMapper.convertirLista(generoRepository.findAll());
    }
}
