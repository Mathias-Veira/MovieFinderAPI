package com.movieFinder.movieFinderAPI.services;

import com.movieFinder.movieFinderAPI.dtos.AccesoDTO;
import com.movieFinder.movieFinderAPI.dtos.UsuarioDTO;
import com.movieFinder.movieFinderAPI.error.IdNotFoundException;
import com.movieFinder.movieFinderAPI.error.IncompleteDataException;
import com.movieFinder.movieFinderAPI.error.LoginException;
import com.movieFinder.movieFinderAPI.error.UserExistsException;

public interface UsuarioService{
    /**
     * Se define un método que permite comprobar el acceso de sesión de un usuario
     * @param accesoDTO Información para el acceso de sesión
     * @return Información del usuario si se cumple el acceso
     */
    UsuarioDTO comprobarAcceso(AccesoDTO accesoDTO) throws IncompleteDataException, LoginException, IdNotFoundException;

    /**
     * Se define un método que permite registrar un usuario a partir de la información indicada
     * @param usuarioDTO Información del usuario a registrar
     * @return Se devuelve la información correspondiente al usuario posteriormente al registro
     */
    UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) throws IncompleteDataException, UserExistsException;
    UsuarioDTO obtenerUsuario(String name);
}
