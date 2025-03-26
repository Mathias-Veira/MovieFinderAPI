package com.movieFinder.movieFinderAPI.error;

/**
 * Esta clase representa la excepción personalizada que se lanza cuando los datos que le llegan a la api están incompletos
 */
public class IncompleteDataException extends Exception{
    public IncompleteDataException(String message) {
        super(message);
    }
}
