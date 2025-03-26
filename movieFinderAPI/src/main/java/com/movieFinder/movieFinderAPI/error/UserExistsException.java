package com.movieFinder.movieFinderAPI.error;
/**
 * Esta clase representa la excepción personalizada que se lanza cuando desde el front, se envía un nombre de usuario que ya existe en la bd
 */
public class UserExistsException extends Exception{
    public UserExistsException(String message) {
        super(message);
    }
}
