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
    @GetMapping("/api/movies")
    ResponseEntity<?> obtenerPeliculas(@RequestParam int page){
        return ResponseEntity.ok(peliculaService.obtenerPeliculas(page));
    }
    @GetMapping("/api/movies_by_name")
    ResponseEntity<?> obtenerPeliculasByMovieName(@RequestParam String titulo,@RequestParam int page){
        return ResponseEntity.ok(peliculaService.findMoviesByMovieName(titulo,page));
    }
    @GetMapping("/api/movie/{idPelicula}")
    ResponseEntity<?> obtenerPeliculaById(@PathVariable int idPelicula) throws IdNotFoundException {return new ResponseEntity<>(peliculaService.obtenerPeliculaById(idPelicula), HttpStatus.OK);}
    @GetMapping("/api/movies/genres/{idGenero}")
    ResponseEntity<?> obtenerPeliculaByGenreId(@PathVariable int idGenero, @RequestParam int page){return new ResponseEntity<>(peliculaService.findMoviesByGenreId(idGenero,page),HttpStatus.OK);}
}
