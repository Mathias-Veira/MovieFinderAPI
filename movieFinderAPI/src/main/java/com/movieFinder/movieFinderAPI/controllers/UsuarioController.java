package com.movieFinder.movieFinderAPI.controllers;

import com.movieFinder.movieFinderAPI.dtos.AccesoDTO;
import com.movieFinder.movieFinderAPI.dtos.UsuarioDTO;
import com.movieFinder.movieFinderAPI.error.IdNotFoundException;
import com.movieFinder.movieFinderAPI.error.IncompleteDataException;
import com.movieFinder.movieFinderAPI.error.LoginException;
import com.movieFinder.movieFinderAPI.error.UserExistsException;
import com.movieFinder.movieFinderAPI.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Esta clase representa el controlador para gestionar la información referente a un usuario
 */
@RestController
@CrossOrigin
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    /**
     * Endpoint que permite validar si la entrada indicada es correcta para la realización de un inicio de sesión
     * @param acceso Información para realizar el inicio de sesión
     * @return Se devuelve la información correspondiente al usuario si el inicio es correcto
     */
    @PostMapping("/api/login")
    ResponseEntity<?> iniciarSesion(@RequestBody AccesoDTO acceso) throws IncompleteDataException, LoginException, IdNotFoundException {
        return new ResponseEntity<>(usuarioService.comprobarAcceso(acceso), HttpStatus.NO_CONTENT);
    }
    /**
     * Endpoint que permite registrar la información correspondiente a un usuario
     * @param usuarioDTO Información del usuario a registrar
     * @return Se devuelve la información posterior al registro
     */
    @PostMapping("/api/usuarios")
    ResponseEntity<?> registrarUsuario(@RequestBody UsuarioDTO usuarioDTO) throws IncompleteDataException, UserExistsException {
        return new ResponseEntity<>(usuarioService.crearUsuario(usuarioDTO), HttpStatus.CREATED);
    }

    /**
     * Este endpoint permite obtener un usuario por su nombre
     * @param nombre nombre de usuario
     * @return Código de respuesta 200 junto con el usuario
     */
    @GetMapping("/api/usuarios/{nombre}")
    ResponseEntity<?> obtenerUsuario(@PathVariable String nombre) {
        return new ResponseEntity<>(usuarioService.obtenerUsuario(nombre), HttpStatus.OK);
    }


}
