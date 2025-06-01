package com.movieFinder.movieFinderAPI.controllers;

import com.movieFinder.movieFinderAPI.error.IdNotFoundException;
import com.movieFinder.movieFinderAPI.services.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Esta clase representa el controlador para gestionar la información referente a una Película
 */
@RestController
@CrossOrigin
public class PeliculaController {
    @Autowired
    private PeliculaService peliculaService;

    /**
     * Método para obtener todas las películas paginadas
     * @param page número de página para obtener las películas
     * @return Código de estado 200 junto con las películas de la página marcada
     */
    @GetMapping("/api/movies")
    ResponseEntity<?> obtenerPeliculas(@RequestParam int page){
        return ResponseEntity.ok(peliculaService.obtenerPeliculas(page));
    }

    /**
     * Método para obtener las películas por nombre
     * @param titulo nombre de la película a buscar
     * @param page página de la que se deben obtener resultados de las películas
     * @return Código de estado 200 junto con las películas de la página marcada
     */
    @GetMapping("/api/movies_by_name")
    ResponseEntity<?> obtenerPeliculasByMovieName(@RequestParam String titulo,@RequestParam int page){
        return ResponseEntity.ok(peliculaService.findMoviesByMovieName(titulo,page));
    }

    /**
     * Método para obtener una película por su id
     * @param idPelicula Identificador de la película
     * @return Código de estado 200 junto con la película
     * @throws IdNotFoundException Se genera esta excepción si el identificador de la película no existe en la base de datos
     */
    @GetMapping("/api/movie/{idPelicula}")
    ResponseEntity<?> obtenerPeliculaById(@PathVariable int idPelicula) throws IdNotFoundException {return new ResponseEntity<>(peliculaService.obtenerPeliculaById(idPelicula), HttpStatus.OK);}

    /**
     * Método para obtener una película por género
     * @param idGenero Identificador del género
     * @param page página para la obtención de resultados de películas
     * @return Código 200 junto con la lista de películas
     */
    @GetMapping("/api/movies/genres/{idGenero}")
    ResponseEntity<?> obtenerPeliculaByGenreId(@PathVariable int idGenero, @RequestParam int page){return new ResponseEntity<>(peliculaService.findMoviesByGenreId(idGenero,page),HttpStatus.OK);}
}
