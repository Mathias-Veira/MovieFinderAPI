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

    /**
     * Método para obtener las valoraciones de una película
     * @param idPelicula identificador de la película
     * @return código de estado 200 junto con las valoraciones
     * @throws IdNotFoundException Se genera esta excepción si el identificador de la película no existe en la base de datos
     */
    @GetMapping("/api/valoraciones/{idPelicula}")
    ResponseEntity<?> obtenerValoracionesPelis(@PathVariable int idPelicula) throws IdNotFoundException{
        return new ResponseEntity<>(valorarService.obtenerValoracionesPelis(idPelicula), HttpStatus.OK);
    }

    /**
     * Método para ingresar una valoración
     * @param valorarDTO Objeto con la información de la valoración
     * @return Código de estado 201 junto con la valoración creada
     * @throws IdNotFoundException Se genera esta excepción si el identificador de la película no existe en la base de datos
     */
    @PostMapping("/api/valoraciones")
    ResponseEntity<?> guardarValoracionPeli(@RequestBody ValorarDTO valorarDTO) throws IdNotFoundException {
        return new ResponseEntity<>(valorarService.guardarValoracionPeli(valorarDTO),HttpStatus.CREATED);
    }
}
