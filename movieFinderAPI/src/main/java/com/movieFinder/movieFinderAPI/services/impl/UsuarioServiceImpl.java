package com.movieFinder.movieFinderAPI.services.impl;

import com.movieFinder.movieFinderAPI.dtos.AccesoDTO;
import com.movieFinder.movieFinderAPI.dtos.UsuarioDTO;
import com.movieFinder.movieFinderAPI.error.IdNotFoundException;
import com.movieFinder.movieFinderAPI.error.IncompleteDataException;
import com.movieFinder.movieFinderAPI.error.LoginException;
import com.movieFinder.movieFinderAPI.error.UserExistsException;
import com.movieFinder.movieFinderAPI.mappers.UsuarioMapper;
import com.movieFinder.movieFinderAPI.models.Usuario;
import com.movieFinder.movieFinderAPI.repositories.UsuarioRepository;
import com.movieFinder.movieFinderAPI.services.UsuarioService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;


@Service
@Lazy
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Método que permite comprobar el acceso de sesión de un usuario
     *
     * @param accesoDTO Información para el acceso de sesión
     * @return Información del usuario si se cumple el acceso
     */
    @Override
    public UsuarioDTO comprobarAcceso(AccesoDTO accesoDTO) throws IncompleteDataException, LoginException, IdNotFoundException {
        if (StringUtils.isBlank(accesoDTO.getNombreUsuario()) || StringUtils.isBlank(accesoDTO.getPasswordUsuario())) {
            throw new IncompleteDataException("El nombre de usuario y contraseña son obligatorios y no pueden estar vacíos");
        }
        Usuario user = usuarioRepository.findByName(accesoDTO.getNombreUsuario());
        if(user == null){
            throw new IdNotFoundException("El usuario no existe");
        }
        if (!user.getPasswordUsuario().equals(accesoDTO.getPasswordUsuario())) {
            //LoginException
            throw new LoginException("Contraseña incorrecta");
        }
        return UsuarioMapper.convertirADTO(user);
    }

    /**
     * Método que permite registrar un usuario a partir de la información indicada
     *
     * @param usuarioDTO Información del usuario a registrar
     * @return Se devuelve la información correspondiente al usuario posteriormente al registro
     */
    @Override
    public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) throws IncompleteDataException, UserExistsException {
        UsuarioDTO user;
        if (StringUtils.isBlank(usuarioDTO.getNombreUsuario()) || StringUtils.isBlank(usuarioDTO.getPasswordUsuario())) {
            throw new IncompleteDataException("El nombre de usuario y contraseña son obligatorios y no pueden estar vacíos");
        }
        user = obtenerUsuario(usuarioDTO.getNombreUsuario());
        if (user != null) {
            throw new UserExistsException("El usuario ya existe");
        }

        return UsuarioMapper.convertirADTO(usuarioRepository.save(UsuarioMapper.convertirAModelo(usuarioDTO)));
    }

    /**
     * Este método permite obtener un usuario por su nombre
     *
     * @param name nombre del usuario a obtener
     * @return objeto UsuarioDTO
     */
    @Override
    public UsuarioDTO obtenerUsuario(String name) {
        if (usuarioRepository.findByName(name) == null) {
            return null;
        }
        return UsuarioMapper.convertirADTO(usuarioRepository.findByName(name));
    }
}
