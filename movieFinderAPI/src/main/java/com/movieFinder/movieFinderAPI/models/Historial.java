package com.movieFinder.movieFinderAPI.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "HISTORIAL")
public class Historial implements Serializable {
    private int idHistorial;
    private int idUsuario;
    private int idPelicula;
    private LocalDate fechaVisto;

    public Historial(){

    }

    public Historial(int idHistorial, int idUsuario, int idPelicula, LocalDate fechaVisto) {
        this.idHistorial = idHistorial;
        this.idUsuario = idUsuario;
        this.idPelicula = idPelicula;
        this.fechaVisto = fechaVisto;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historial")
    public int getIdHistorial() {
        return idHistorial;
    }
    @Column(name = "id_usuario")
    public int getIdUsuario() {
        return idUsuario;
    }
    @Column(name = "id_pelicula")
    public int getIdPelicula() {
        return idPelicula;
    }
    @Column(name = "fecha_visto")
    public LocalDate getFechaVisto() {
        return fechaVisto;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public void setFechaVisto(LocalDate fechaVisto) {
        this.fechaVisto = fechaVisto;
    }
}
