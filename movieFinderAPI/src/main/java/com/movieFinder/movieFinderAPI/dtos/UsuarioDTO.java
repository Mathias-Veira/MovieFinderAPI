package com.movieFinder.movieFinderAPI.dtos;

/**
 * Esta clase representa los datos del usuario
 */
public class UsuarioDTO {
    private int idUsuario;
    private String nombreUsuario;
    private String passwordUsuario;

    /**
     * Constructor vacío
     */
    public UsuarioDTO(){

    }

    /**
     * Constructor completo
     * @param idUsuario identificador del usuario
     * @param nombreUsuario nombre del usuario
     */
    public UsuarioDTO(int idUsuario, String nombreUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;

    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }
}
