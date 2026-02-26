package com.movieFinder.movieFinderAPI.error;

public class NotRefreshTokenException extends RuntimeException{
    public NotRefreshTokenException(String message) {
        super(message);
    }
}
