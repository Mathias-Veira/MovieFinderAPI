package com.movieFinder.movieFinderAPI.services.impl;

import com.movieFinder.movieFinderAPI.dtos.HistorialDTO;
import com.movieFinder.movieFinderAPI.error.IdNotFoundException;
import com.movieFinder.movieFinderAPI.mappers.HistorialMapper;
import com.movieFinder.movieFinderAPI.mappers.HistorialPeliculaMapper;
import com.movieFinder.movieFinderAPI.dtos.HistorialPeliculaDTO;
import com.movieFinder.movieFinderAPI.repositories.HistorialRepository;
import com.movieFinder.movieFinderAPI.repositories.UsuarioRepository;
import com.movieFinder.movieFinderAPI.services.HistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Lazy
@Component
public class HistorialServiceImpl implements HistorialService {
    @Autowired
    private HistorialRepository historialRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public List<HistorialPeliculaDTO> obtenerHistorialPelicula(int idUsuario) throws IdNotFoundException{
        if(!usuarioRepository.existsById(idUsuario)){
            throw new IdNotFoundException("El usuario no existe");
        }
        return HistorialPeliculaMapper.convertirLista(historialRepository.obtenerHistorialPelicula(idUsuario));
    }
}
