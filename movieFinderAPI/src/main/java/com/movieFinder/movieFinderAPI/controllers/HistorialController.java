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
    /**
     * Método para obtener las películas vistas de un usuario
     * @param idUsuario Identificador del usuario
     * @return Código de estado 200 junto con el listado con las películas que el usuario haya marcado como vistas
     * @throws IdNotFoundException Se genera esta excepción si el identificador del usuario no existe en la base de datos
     */
    @GetMapping("/api/historial/{idUsuario}")
    ResponseEntity<?> obtenerListaHistorial(@PathVariable int idUsuario) throws IdNotFoundException {
        return new ResponseEntity<>(historialService.obtenerHistorialPelicula(idUsuario), HttpStatus.OK);
    }

    /**
     * Método para almacenar una película en favoritos
     * @param historialDTO objeto con información de la película marcada como vista y el usuario que la haya marcado
     * @return Código de estado 201 junto con el objeto favoritoDTO almacenado en base de datos
     * @throws IdNotFoundException Se genera esta excepción si el identificador del usuario o de la película no existe en la base de datos
     */
    @PostMapping("/api/historial")
    ResponseEntity<?> guardarPeliHistorial(@RequestBody HistorialDTO historialDTO) throws IdNotFoundException{
        return new ResponseEntity<>(historialService.guardarPeliHistorial(historialDTO.getIdUsuario(), historialDTO.getIdPelicula()),HttpStatus.CREATED);
    }

    /**
     * Método para borrar la película del historial
     * @param idUsuario Identificador del usuario
     * @param idPelicula Identificador de la película
     * @return Código de estado 204
     * @throws IdNotFoundException Se genera esta excepción si el identificador del usuario o de la película no existe en la base de datos
     */
    @DeleteMapping("/api/eliminar/historial/{idUsuario}/{idPelicula}")
    ResponseEntity<?> borrarPeliHistorial(@PathVariable int idUsuario,@PathVariable int idPelicula) throws IdNotFoundException{
        historialService.borrarPeliHistorial(idUsuario,idPelicula);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Método para obtener una película en específico de la lista del historial
     * @param idUsuario Identificador del usuario
     * @param idPelicula Identificador de la película
     * @return Código de estado 200 junto con la película
     * @throws IdNotFoundException Se genera esta excepción si el identificador del usuario o de la película no existe en la base de datos
     */
    @GetMapping("/api/historial/{idUsuario}/{idPelicula}")
    ResponseEntity<?> obtenerPeliculaHistorial(@PathVariable int idUsuario,@PathVariable int idPelicula) throws IdNotFoundException {
        return new ResponseEntity<>(historialService.obtenerPeliculaHistorial(idUsuario, idPelicula), HttpStatus.OK);
    }
}
