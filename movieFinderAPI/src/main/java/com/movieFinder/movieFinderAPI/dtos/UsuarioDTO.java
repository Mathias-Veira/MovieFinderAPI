package com.movieFinder.movieFinderAPI.dtos;

/**
 * Esta clase representa los datos del usuario
 */
public class UsuarioDTO {
    private int idUsuario;
    private String nombreUsuario;
    private String emailUsuario;
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
    public UsuarioDTO(int idUsuario, String nombreUsuario,String emailUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.emailUsuario = emailUsuario;
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
    public String getEmailUsuario(){return emailUsuario;}
    public void setEmailUsuario(String emailUsuario){this.emailUsuario = emailUsuario;}

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }
}
