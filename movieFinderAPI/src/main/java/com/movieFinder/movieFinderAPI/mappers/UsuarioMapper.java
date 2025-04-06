package com.movieFinder.movieFinderAPI.mappers;

import com.movieFinder.movieFinderAPI.dtos.UsuarioDTO;
import com.movieFinder.movieFinderAPI.models.Usuario;

/**
 * Esta clase realiza las conversiones necesarias entre objetos Usuario y usuarioDTO
 */
public class UsuarioMapper {
    /**
     * Este método permite convertir de modelo a UsuarioDTO
     * @param usuario objeto de la clase Usuario
     * @return objeto de la clase UsuarioDTO
     */
    public static UsuarioDTO convertirADTO(Usuario usuario){
        return new UsuarioDTO(usuario.getIdUsuario(), usuario.getNombreUsuario(), usuario.getEmailUsuario());
    }

    /**
     * Este método permite convertir de UsuarioDTO a modelo
     * @param usuarioDTO objeto de la clase UsuarioDTO
     * @return objeto de la clase Usuario
     */
    public static Usuario convertirAModelo(UsuarioDTO usuarioDTO){
        return new Usuario(usuarioDTO.getIdUsuario(), usuarioDTO.getNombreUsuario(), usuarioDTO.getEmailUsuario(), usuarioDTO.getPasswordUsuario());
    }
}
