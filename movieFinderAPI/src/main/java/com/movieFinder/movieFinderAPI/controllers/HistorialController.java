package com.movieFinder.movieFinderAPI.controllers;

import com.movieFinder.movieFinderAPI.dtos.HistorialDTO;
import com.movieFinder.movieFinderAPI.error.IdNotFoundException;
import com.movieFinder.movieFinderAPI.services.HistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/api/historial")
    ResponseEntity<?> guardarPeliHistorial(@RequestBody HistorialDTO historialDTO) throws IdNotFoundException{
        return new ResponseEntity<>(historialService.guardarPeliHistorial(historialDTO.getIdUsuario(), historialDTO.getIdPelicula()),HttpStatus.CREATED);
    }

    @DeleteMapping("/api/eliminar/historial/{idUsuario}/{idPelicula}")
    ResponseEntity<?> borrarPeliHistorial(@PathVariable int idUsuario,@PathVariable int idPelicula) throws IdNotFoundException{
        historialService.borrarPeliHistorial(idUsuario,idPelicula);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/api/historial/{idUsuario}/{idPelicula}")
    ResponseEntity<?> obtenerPeliculaHistorial(@PathVariable int idUsuario,@PathVariable int idPelicula) throws IdNotFoundException {
        return new ResponseEntity<>(historialService.obtenerPeliculaHistorial(idUsuario, idPelicula), HttpStatus.OK);
    }
}
