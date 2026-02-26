package com.movieFinder.movieFinderAPI.services;

import com.movieFinder.movieFinderAPI.dtos.AccesoDTO;
import com.movieFinder.movieFinderAPI.dtos.TokenDTO;
import com.movieFinder.movieFinderAPI.dtos.UsuarioDTO;
import com.movieFinder.movieFinderAPI.error.*;

public interface UsuarioService{
    /**
     * Se define un método que permite comprobar el acceso de sesión de un usuario
     * @param accesoDTO Información para el acceso de sesión
     * @return Información del usuario si se cumple el acceso
     */
    TokenDTO comprobarAcceso(AccesoDTO accesoDTO) throws IncompleteDataException, LoginException, IdNotFoundException;

    /**
     * Se define un método que permite registrar un usuario a partir de la información indicada
     * @param usuarioDTO Información del usuario a registrar
     * @return Se devuelve la información correspondiente al usuario posteriormente al registro
     */
    UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) throws IncompleteDataException, UserExistsException;
    UsuarioDTO obtenerUsuario(String name);
    TokenDTO sendRefreshToken(String refreshToken) throws NotRefreshTokenException;
}
