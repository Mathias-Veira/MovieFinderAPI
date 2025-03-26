package com.movieFinder.movieFinderAPI.error;


import com.movieFinder.movieFinderAPI.error.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Clase general que controla las excepciones
 */
@ControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {
    /**
     * Este método recoge la excepción personalizada IncompleteDataException y devuelve un código de respuesta 400
     * @param exception la excepción que se genera
     * @return código de respuesta 400
     */
    @ExceptionHandler(IncompleteDataException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorDTO> IncompleteDataException(IncompleteDataException exception){
        ErrorDTO error = new ErrorDTO(HttpStatus.BAD_REQUEST,exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    /**
     * Este método recoge la excepción personalizada LoginException y devuelve un código de respuesta 400
     * @param exception la excepción que se genera
     * @return código de respuesta 400
     */
    @ExceptionHandler(LoginException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorDTO> LoginException(LoginException exception){
        ErrorDTO error = new ErrorDTO(HttpStatus.BAD_REQUEST,exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    /**
     * Este método recoge la excepción personalizada IdNotFoundException y devuelve un código de respuesta 404
     * @param exception excepción que se genera
     * @return código de respuesta 404
     */
    @ExceptionHandler(IdNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorDTO> IdNotFoundException(IdNotFoundException exception){
        ErrorDTO error = new ErrorDTO(HttpStatus.NOT_FOUND,exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    /**
     * Este método recoge la excepción personalizada UserExistsException y devuelve un código de respuesta 404
     * @param exception excepción que se genera
     * @return código de respuesta 400
     */
    @ExceptionHandler(UserExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorDTO> UserExistsException(UserExistsException exception){
        ErrorDTO error = new ErrorDTO(HttpStatus.BAD_REQUEST,exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
