package com.movieFinder.movieFinderAPI;

import com.movieFinder.movieFinderAPI.dtos.UsuarioDTO;
import com.movieFinder.movieFinderAPI.error.IncompleteDataException;
import com.movieFinder.movieFinderAPI.error.UserExistsException;
import com.movieFinder.movieFinderAPI.mappers.UsuarioMapper;
import com.movieFinder.movieFinderAPI.models.Usuario;
import com.movieFinder.movieFinderAPI.repositories.UsuarioRepository;
import com.movieFinder.movieFinderAPI.services.impl.UsuarioServiceImpl;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UsuarioRepository usuarioRepository;
    @InjectMocks
    private UsuarioServiceImpl usuarioService;


    @Test
    public void shouldThrowExceptionWhenDataIsIncomplete() throws UserExistsException, IncompleteDataException {
        UsuarioDTO usuario = new UsuarioDTO(1,"Mathias","mveirad@gmail.com");
        assertThrows(IncompleteDataException.class,() ->{usuarioService.crearUsuario(usuario);} );
    }
    @Test
    public void shouldReturnCreatedUser() throws UserExistsException, IncompleteDataException {
        Usuario usuario = new Usuario(1,"Mathias","mveirad@gmail.com","user123456");
        when(usuarioRepository.findByName(anyString())).thenReturn(null);
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);
        UsuarioDTO usuarioDTO = new UsuarioDTO(1,"Mathias","mveirad@gmail.com");
        usuarioDTO.setPasswordUsuario("user123456");
        UsuarioDTO result = usuarioService.crearUsuario(usuarioDTO);
        assertEquals(usuario.getNombreUsuario(),result.getNombreUsuario());
    }

    @Test
    public void shouldThrowExceptionWhenUserAlreadyExists(){
        UsuarioDTO usuario = new UsuarioDTO(1,"Mathias","mveirad@gmail.com");
        usuario.setPasswordUsuario("user123456");
        Usuario userExistente = new Usuario(1,"Mathias","mveirad@gmail.com","user123456");
        when(usuarioRepository.findByName(anyString())).thenReturn(userExistente);

        assertThrows(UserExistsException.class,()->{usuarioService.crearUsuario(usuario);});
    }
}
