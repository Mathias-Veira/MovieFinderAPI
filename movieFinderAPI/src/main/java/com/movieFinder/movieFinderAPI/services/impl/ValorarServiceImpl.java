package com.movieFinder.movieFinderAPI.services.impl;


import com.movieFinder.movieFinderAPI.dtos.ValorarPeliculaDTO;
import com.movieFinder.movieFinderAPI.error.IdNotFoundException;
import com.movieFinder.movieFinderAPI.mappers.ValorarPeliculaMapper;
import com.movieFinder.movieFinderAPI.repositories.PeliculaRepository;
import com.movieFinder.movieFinderAPI.repositories.ValorarRepository;
import com.movieFinder.movieFinderAPI.services.ValorarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Lazy
public class ValorarServiceImpl implements ValorarService {
    @Autowired
    private ValorarRepository valorarRepository;
    @Autowired
    private PeliculaRepository peliculaRepository;
    @Override
    public List<ValorarPeliculaDTO> obtenerValoracionesPelis(int idPelicula) throws IdNotFoundException {
        if(!peliculaRepository.existsById(idPelicula)){
            throw new IdNotFoundException("La película no existe");
        }
        return ValorarPeliculaMapper.convertirLista(valorarRepository.obtenerValoracionesPelis(idPelicula));
    }
}
