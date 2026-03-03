package com.movieFinder.movieFinderAPI;


import com.movieFinder.movieFinderAPI.error.IdNotFoundException;
import com.movieFinder.movieFinderAPI.mappers.PeliculaMapper;
import com.movieFinder.movieFinderAPI.models.Pelicula;
import com.movieFinder.movieFinderAPI.repositories.PeliculaRepository;
import com.movieFinder.movieFinderAPI.services.impl.PeliculaServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PeliculaServiceTest {
    @Mock
    private PeliculaRepository peliculaRepository;
    @InjectMocks
    private PeliculaServiceImpl peliculaService;

    @Test
    public void shouldReturnMovieWhenExists() throws IdNotFoundException {
        Pelicula pelicula = new Pelicula(1,"Cars","Cars","Sinopsis cars", LocalDate.of(2006,3,14),"posterPelicula");
        when(peliculaRepository.findById(1)).thenReturn(Optional.of(pelicula));
        Pelicula result = PeliculaMapper.convertirAModelo(peliculaService.obtenerPeliculaById(1));
        assertEquals(pelicula.getTituloPelicula(),result.getTituloPelicula());
    }

    @Test
    public void shouldThrowExceptionWhenMovieIdNotFound() throws IdNotFoundException {
        Pelicula pelicula = new Pelicula(1,"Cars","Cars","Sinopsis cars", LocalDate.of(2006,3,14),"posterPelicula");
        when(peliculaRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(IdNotFoundException.class,() ->{ peliculaService.obtenerPeliculaById(1);});
    }
}
