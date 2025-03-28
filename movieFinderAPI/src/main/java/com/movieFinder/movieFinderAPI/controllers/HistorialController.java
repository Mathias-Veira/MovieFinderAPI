package com.movieFinder.movieFinderAPI.controllers;

import com.movieFinder.movieFinderAPI.error.IdNotFoundException;
import com.movieFinder.movieFinderAPI.services.HistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Esta clase representa el controlador para gestionar la información referente al historial de películas vistas por el usuario
 */
@RestController
@CrossOrigin
public class HistorialController {
    @Autowired
    private HistorialService historialService;
    @GetMapping("/api/historial/{idUsuario}")
    ResponseEntity<?> obtenerListaHistorial(@PathVariable int idUsuario) throws IdNotFoundException {
        return new ResponseEntity<>(historialService.obtenerHistorialPelicula(idUsuario), HttpStatus.OK);
    }
}
