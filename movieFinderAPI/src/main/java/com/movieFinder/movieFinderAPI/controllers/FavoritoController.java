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
    @GetMapping("/api/favoritos/{idUsuario}")
    ResponseEntity<?> obtenerListaFavoritos(@PathVariable int idUsuario) throws IdNotFoundException {
        return new ResponseEntity<>(favoritoService.obtenerListaFavoritos(idUsuario), HttpStatus.OK);
    }
    @PostMapping("/api/favoritos")
    ResponseEntity<?> guardarPeliFavoritos(@RequestBody FavoritoDTO favoritoDTO) throws IdNotFoundException{
        return new ResponseEntity<>(favoritoService.guardarPeliFavoritos(favoritoDTO.getIdUsuario(), favoritoDTO.getIdPelicula()),HttpStatus.CREATED);
    }
    @DeleteMapping("/api/eliminar/favoritos")
    ResponseEntity<?> borrarPeliFavoritos(@RequestBody FavoritoDTO favoritoDTO) throws IdNotFoundException{
        favoritoService.borrarPeliFavoritos(favoritoDTO.getIdUsuario(), favoritoDTO.getIdPelicula());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/api/favoritos/{idUsuario}/{idPelicula}")
    ResponseEntity<?> obtenerPeliculaFavorito(@PathVariable int idUsuario,@PathVariable int idPelicula) throws IdNotFoundException {
        return new ResponseEntity<>(favoritoService.obtenerPeliculaFavorito(idUsuario, idPelicula), HttpStatus.OK);
    }
}
