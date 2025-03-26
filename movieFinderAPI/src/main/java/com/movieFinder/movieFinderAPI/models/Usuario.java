package com.movieFinder.movieFinderAPI.models;


import jakarta.persistence.*;

import java.io.Serializable;
/**
 * Esta clase representa los datos del usuario
 */
@Entity
@Table(name = "USUARIOS")
public class Usuario implements Serializable {
    private int idUsuario;
    private String nombreUsuario;
    private String passwordUsuario;

    /**
     * Constructor vacío
     */
    public Usuario(){

    }
    /**
     * Constructor completo
     * @param idUsuario identificador del usuario
     * @param nombreUsuario nombre del usuario
     */
    public Usuario(int idUsuario, String nombreUsuario, String passwordUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.passwordUsuario = passwordUsuario;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    @Column(name = "nombre_usuario")
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    @Column(name = "password_usuario")
    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }
}
