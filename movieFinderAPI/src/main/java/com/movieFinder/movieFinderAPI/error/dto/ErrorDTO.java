package com.movieFinder.movieFinderAPI.error.dto;

import org.springframework.http.HttpStatus;

/**
 * Clase que contiene información sobre un error
 */
public class ErrorDTO {
    private HttpStatus statusCode;
    private String mensaje;

    /**
     * Constructor vacío
     */
    public ErrorDTO() {
    }

    /**
     * Constructor completo
     * @param statusCode código de respuesta
     * @param mensaje descripción del mensaje
     */
    public ErrorDTO(HttpStatus statusCode, String mensaje) {
        this.statusCode = statusCode;
        this.mensaje = mensaje;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
