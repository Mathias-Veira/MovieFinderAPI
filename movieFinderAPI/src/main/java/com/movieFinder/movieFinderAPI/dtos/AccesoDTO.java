package com.movieFinder.movieFinderAPI.dtos;

/**
 * Esta clase representa los datos necesarios para realizar el inicio de sesión
 */
public class AccesoDTO {
    private  int idUsuario;
    private String nombreUsuario;
    private String passwordUsuario;

    /**
     * Constructor completo
     * @param nombreUsuario nombre de usuario
     * @param passwordUsuario contraseña del usuario
     */
    public AccesoDTO(int idUsuario, String nombreUsuario, String passwordUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.passwordUsuario = passwordUsuario;
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
