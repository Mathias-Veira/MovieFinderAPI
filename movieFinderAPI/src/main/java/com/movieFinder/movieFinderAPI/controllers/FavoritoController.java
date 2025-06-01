package com.movieFinder.movieFinderAPI.controllers;

import com.movieFinder.movieFinderAPI.dtos.FavoritoDTO;
import com.movieFinder.movieFinderAPI.error.IdNotFoundException;
import com.movieFinder.movieFinderAPI.services.FavoritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Esta clase representa el controlador para gestionar la información referente a las películas que están en favoritos
 */
@RestController
@CrossOrigin
public class FavoritoController {
    @Autowired
    private FavoritoService favoritoService;

    /**
     * Método para obtener las películas favoritas de un usuario
     * @param idUsuario Identificador del usuario
     * @return Código de estado 200 junto con el listado con las películas que el usuario haya marcado como favoritas
     * @throws IdNotFoundException Se genera esta excepción si el identificador del usuario no existe en la base de datos
     */
    @GetMapping("/api/favoritos/{idUsuario}")
    ResponseEntity<?> obtenerListaFavoritos(@PathVariable int idUsuario) throws IdNotFoundException {
        return new ResponseEntity<>(favoritoService.obtenerListaFavoritos(idUsuario), HttpStatus.OK);
    }

    /**
     * Método para almacenar una película en favoritos
     * @param favoritoDTO objeto con información de la película marcada como favorita y el usuario que la haya marcado
     * @return Código de estado 201 junto con el objeto favoritoDTO almacenado en base de datos
     * @throws IdNotFoundException Se genera esta excepción si el identificador del usuario o de la película no existe en la base de datos
     */
    @PostMapping("/api/favoritos")
    ResponseEntity<?> guardarPeliFavoritos(@RequestBody FavoritoDTO favoritoDTO) throws IdNotFoundException{
        return new ResponseEntity<>(favoritoService.guardarPeliFavoritos(favoritoDTO.getIdUsuario(), favoritoDTO.getIdPelicula()),HttpStatus.CREATED);
    }

    /**
     * Método para borrar la película de favoritos
     * @param favoritoDTO objeto con información de la película marcada como favorita y el usuario que la haya marcado
     * @return Código de estado 204
     * @throws IdNotFoundException Se genera esta excepción si el identificador del usuario o de la película no existe en la base de datos
     */
    @DeleteMapping("/api/eliminar/favoritos")
    ResponseEntity<?> borrarPeliFavoritos(@RequestBody FavoritoDTO favoritoDTO) throws IdNotFoundException{
        favoritoService.borrarPeliFavoritos(favoritoDTO.getIdUsuario(), favoritoDTO.getIdPelicula());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Método para obtener una película en específico de la lista de favoritos
     * @param idUsuario Identificador del usuario
     * @param idPelicula Identificador de la película
     * @return Código de estado 200 junto con la película
     * @throws IdNotFoundException Se genera esta excepción si el identificador del usuario o de la película no existe en la base de datos
     */
    @GetMapping("/api/favoritos/{idUsuario}/{idPelicula}")
    ResponseEntity<?> obtenerPeliculaFavorito(@PathVariable int idUsuario,@PathVariable int idPelicula) throws IdNotFoundException {
        return new ResponseEntity<>(favoritoService.obtenerPeliculaFavorito(idUsuario, idPelicula), HttpStatus.OK);
    }
}
