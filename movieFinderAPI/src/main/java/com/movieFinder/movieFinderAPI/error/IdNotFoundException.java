package com.movieFinder.movieFinderAPI.error;

/**
 * Esta clase representa la excepción personalizada que se lanza cuando no se encuentra un identificador
 */
public class IdNotFoundException extends Exception{
    public IdNotFoundException(String message) {
        super(message);
    }
}
