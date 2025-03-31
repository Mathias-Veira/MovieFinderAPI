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
    @GetMapping("/api/generos")
    ResponseEntity<?> obtenerGeneros(){
        return new ResponseEntity<>(generoService.obtenerGeneros(), HttpStatus.OK);
    }
    @GetMapping("/api/generos/{idPelicula}")
    ResponseEntity<?> obtenerGenerosById(@PathVariable() int idPelicula) throws IdNotFoundException {
        return new ResponseEntity<>(generoService.obtenerGeneros(idPelicula), HttpStatus.OK);
    }
}
