package com.movieFinder.movieFinderAPI.controllers;

import com.movieFinder.movieFinderAPI.error.IdNotFoundException;
import com.movieFinder.movieFinderAPI.services.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Esta clase representa el controlador para gestionar la información referente a los géneros
 */
@RestController
@CrossOrigin
public class GeneroController {
    @Autowired
    private GeneroService generoService;

    /**
     * Método para obtener los géneros
     * @return Código de estado 200 junto con los géneros
     */
    @GetMapping("/api/generos")
    ResponseEntity<?> obtenerGeneros(){
        return new ResponseEntity<>(generoService.obtenerGeneros(), HttpStatus.OK);
    }

    /**
     * Método para obtener los géneros de una película
     * @param idPelicula identificador de una película
     * @return Código de estado 200 junto con los géneros de la película
     * @throws IdNotFoundException Se genera esta excepción si el identificador de la película no existe en la base de datos
     */
    @GetMapping("/api/generos/{idPelicula}")
    ResponseEntity<?> obtenerGenerosByMovieId(@PathVariable() int idPelicula) throws IdNotFoundException {
        return new ResponseEntity<>(generoService.obtenerGenerosByMovieId(idPelicula), HttpStatus.OK);
    }
}
