package com.movieFinder.movieFinderAPI.controllers;

import com.movieFinder.movieFinderAPI.services.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Esta clase representa el controlador para gestionar la información referente a una Película
 */
@RestController
@CrossOrigin
public class PeliculaController {
    @Autowired
    private PeliculaService peliculaService;
    @GetMapping("api/movies")
    ResponseEntity<?> obtenerPeliculas(){
        return ResponseEntity.ok(peliculaService.obtenerPeliculas());
    }
}
