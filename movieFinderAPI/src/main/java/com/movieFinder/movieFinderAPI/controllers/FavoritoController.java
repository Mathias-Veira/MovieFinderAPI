package com.movieFinder.movieFinderAPI.controllers;

import com.movieFinder.movieFinderAPI.error.IdNotFoundException;
import com.movieFinder.movieFinderAPI.services.FavoritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
