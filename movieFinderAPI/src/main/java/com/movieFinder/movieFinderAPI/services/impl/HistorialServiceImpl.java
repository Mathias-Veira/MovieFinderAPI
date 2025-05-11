package com.movieFinder.movieFinderAPI.services.impl;

import com.movieFinder.movieFinderAPI.dtos.HistorialDTO;
import com.movieFinder.movieFinderAPI.error.IdNotFoundException;
import com.movieFinder.movieFinderAPI.mappers.HistorialMapper;
import com.movieFinder.movieFinderAPI.mappers.HistorialPeliculaMapper;
import com.movieFinder.movieFinderAPI.dtos.HistorialPeliculaDTO;
import com.movieFinder.movieFinderAPI.models.Historial;
import com.movieFinder.movieFinderAPI.repositories.HistorialRepository;
import com.movieFinder.movieFinderAPI.repositories.PeliculaRepository;
import com.movieFinder.movieFinderAPI.repositories.UsuarioRepository;
import com.movieFinder.movieFinderAPI.services.HistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
@Lazy
@Component
public class HistorialServiceImpl implements HistorialService {
    @Autowired
    private HistorialRepository historialRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PeliculaRepository peliculaRepository;
    @Override
    public List<HistorialPeliculaDTO> obtenerHistorialPelicula(int idUsuario) throws IdNotFoundException{
        if(!usuarioRepository.existsById(idUsuario)){
            throw new IdNotFoundException("El usuario no existe");
        }
        return HistorialPeliculaMapper.convertirLista(historialRepository.obtenerHistorialPelicula(idUsuario));
    }

    @Override
    public HistorialDTO guardarPeliHistorial(int idUsuario, int idPelicula) throws IdNotFoundException {
        if(!usuarioRepository.existsById(idUsuario) || !peliculaRepository.existsById(idPelicula)){
            throw new IdNotFoundException("El usuario o la película no existen");
        }
        return HistorialMapper.convertirADTO(historialRepository.save(new Historial(0,idUsuario,idPelicula,LocalDate.now())));
    }

    @Override
    public void borrarPeliHistorial(int idUsuario, int idPelicula) throws IdNotFoundException {
        if(!usuarioRepository.existsById(idUsuario) || !peliculaRepository.existsById(idPelicula)){
            throw new IdNotFoundException("El usuario o la película no existen");
        }
        historialRepository.eliminarPeliculaHistorial(idUsuario,idPelicula);
    }

    @Override
    public HistorialDTO obtenerPeliculaHistorial(int idUsuario, int idPelicula) throws IdNotFoundException {
        if(!usuarioRepository.existsById(idUsuario) || !peliculaRepository.existsById(idPelicula)){
            throw new IdNotFoundException("El usuario o la película no existen");
        }
        if(historialRepository.obtenerPeliculaHistorial(idUsuario, idPelicula) == null){
            throw new IdNotFoundException("El usuario o la película no existe en el historial");
        }
        return HistorialMapper.convertirADTO( historialRepository.obtenerPeliculaHistorial(idUsuario,idPelicula));
    }
}
