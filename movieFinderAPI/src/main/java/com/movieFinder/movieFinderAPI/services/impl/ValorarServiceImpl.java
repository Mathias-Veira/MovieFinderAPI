package com.movieFinder.movieFinderAPI.services.impl;


import com.movieFinder.movieFinderAPI.dtos.ValorarDTO;
import com.movieFinder.movieFinderAPI.dtos.ValorarPeliculaDTO;
import com.movieFinder.movieFinderAPI.error.IdNotFoundException;
import com.movieFinder.movieFinderAPI.mappers.ValorarMapper;
import com.movieFinder.movieFinderAPI.mappers.ValorarPeliculaMapper;
import com.movieFinder.movieFinderAPI.repositories.PeliculaRepository;
import com.movieFinder.movieFinderAPI.repositories.UsuarioRepository;
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
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public List<ValorarPeliculaDTO> obtenerValoracionesPelis(int idPelicula) throws IdNotFoundException {
        if(!peliculaRepository.existsById(idPelicula)){
            throw new IdNotFoundException("La película no existe");
        }
        return ValorarPeliculaMapper.convertirLista(valorarRepository.obtenerValoracionesPelis(idPelicula));
    }

    @Override
    public ValorarDTO guardarValoracionPeli(ValorarDTO valorarDTO) throws IdNotFoundException {
        if(!usuarioRepository.existsById(valorarDTO.getIdUsuario()) || !peliculaRepository.existsById(valorarDTO.getIdPelicula())){
            throw new IdNotFoundException("El usuario o la película no existen");
        }

        return ValorarMapper.convertirADTO(valorarRepository.save(ValorarMapper.convertirAModelo(valorarDTO)));
    }
}
