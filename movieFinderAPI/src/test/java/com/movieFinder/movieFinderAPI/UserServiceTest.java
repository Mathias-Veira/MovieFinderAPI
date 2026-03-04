package com.movieFinder.movieFinderAPI;

import com.movieFinder.movieFinderAPI.error.IncompleteDataException;
import com.movieFinder.movieFinderAPI.error.UserExistsException;
import com.movieFinder.movieFinderAPI.mappers.UsuarioMapper;
import com.movieFinder.movieFinderAPI.models.Usuario;
import com.movieFinder.movieFinderAPI.repositories.UsuarioRepository;
import com.movieFinder.movieFinderAPI.services.impl.UsuarioServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
        Usuario usuario = new Usuario(1,"Mathias","mveirad@gmail.com","");
        assertThrows(IncompleteDataException.class,() ->{usuarioService.crearUsuario(UsuarioMapper.convertirADTO(usuario));} );
    }
    
}
