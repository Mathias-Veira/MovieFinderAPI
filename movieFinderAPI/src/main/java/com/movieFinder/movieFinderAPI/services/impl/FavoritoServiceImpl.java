package com.movieFinder.movieFinderAPI.services.impl;

import com.movieFinder.movieFinderAPI.dtos.FavoritoDTO;
import com.movieFinder.movieFinderAPI.error.IdNotFoundException;
import com.movieFinder.movieFinderAPI.mappers.FavoritoMapper;
import com.movieFinder.movieFinderAPI.models.Favorito;
import com.movieFinder.movieFinderAPI.repositories.FavoritoRepository;
import com.movieFinder.movieFinderAPI.repositories.PeliculaRepository;
import com.movieFinder.movieFinderAPI.repositories.UsuarioRepository;
import com.movieFinder.movieFinderAPI.services.FavoritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Lazy
@Component
public class FavoritoServiceImpl implements FavoritoService {
    @Autowired
    private FavoritoRepository favoritoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PeliculaRepository peliculaRepository;
    @Override
    public List<FavoritoDTO> obtenerListaFavoritos(int idUsuario) throws IdNotFoundException {
        if (!usuarioRepository.existsById(idUsuario)) {
            throw new IdNotFoundException("El usuario no existe");
        }
        return FavoritoMapper.convertirLista(favoritoRepository.obtenerListaFavoritos(idUsuario));

    }

    @Override
    public FavoritoDTO guardarPeliFavoritos(int idUsuario, int idPelicula) throws IdNotFoundException {
        if(!usuarioRepository.existsById(idUsuario) || !peliculaRepository.existsById(idPelicula)){
            throw new IdNotFoundException("El usuario o la película no existen");
        }
        return FavoritoMapper.convertirADTO(favoritoRepository.save(new Favorito(0,idUsuario,idPelicula)));
    }

}
