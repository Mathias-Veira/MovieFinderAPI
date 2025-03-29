package com.movieFinder.movieFinderAPI.controllers;

import com.movieFinder.movieFinderAPI.error.IdNotFoundException;
import com.movieFinder.movieFinderAPI.dtos.ValorarDTO;
import com.movieFinder.movieFinderAPI.services.ValorarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Esta clase representa el controlador para gestionar la información referente a las valoraciones
 */
@RestController
@CrossOrigin
public class ValorarController {
    @Autowired
    private ValorarService valorarService;

    @GetMapping("/api/valoraciones/{idPelicula}")
    ResponseEntity<?> obtenerValoracionesPelis(@PathVariable int idPelicula) throws IdNotFoundException{
        return new ResponseEntity<>(valorarService.obtenerValoracionesPelis(idPelicula), HttpStatus.OK);
    }
    @PostMapping("/api/valoraciones")
    ResponseEntity<?> guardarValoracionPeli(@RequestBody ValorarDTO valorarDTO) throws IdNotFoundException {
        return new ResponseEntity<>(valorarService.guardarValoracionPeli(valorarDTO),HttpStatus.CREATED);
    }
}
