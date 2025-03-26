package com.movieFinder.movieFinderAPI.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Table(name = "PELICULA")
public class Pelicula  implements Serializable {
    private int idPelicula;
    private String tituloPelicula;
    private String tituloOriginalPelicula;
    private String sinopsisPelicula;
    private LocalDate fechaSalidaPelicula;
    private String urlPosterPelicula;

    public Pelicula() {
    }

    public Pelicula(int idPelicula, String tituloPelicula, String tituloOriginalPelicula, String sinopsisPelicula, LocalDate fechaSalidaPelicula, String urlPosterPelicula) {
        this.idPelicula = idPelicula;
        this.tituloPelicula = tituloPelicula;
        this.tituloOriginalPelicula = tituloOriginalPelicula;
        this.sinopsisPelicula = sinopsisPelicula;
        this.fechaSalidaPelicula = fechaSalidaPelicula;
        this.urlPosterPelicula = urlPosterPelicula;
    }
    @Id
    @Column(name = "id_pelicula")
    public int getIdPelicula() {
        return idPelicula;
    }
    @Column(name = "titulo_pelicula")
    public String getTituloPelicula() {
        return tituloPelicula;
    }
    @Column(name = "titulo_original_pelicula")
    public String getTituloOriginalPelicula() {
        return tituloOriginalPelicula;
    }
    @Column(name = "sinopsis_pelicula")
    public String getSinopsisPelicula() {
        return sinopsisPelicula;
    }
    @Column(name = "fecha_salida_pelicula")
    public LocalDate getFechaSalidaPelicula() {
        return fechaSalidaPelicula;
    }
    @Column(name = "url_poster_pelicula")
    public String getUrlPosterPelicula() {
        return urlPosterPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public void setTituloPelicula(String tituloPelicula) {
        this.tituloPelicula = tituloPelicula;
    }

    public void setTituloOriginalPelicula(String tituloOriginalPelicula) {
        this.tituloOriginalPelicula = tituloOriginalPelicula;
    }

    public void setSinopsisPelicula(String sinopsisPelicula) {
        this.sinopsisPelicula = sinopsisPelicula;
    }

    public void setFechaSalidaPelicula(LocalDate fechaSalidaPelicula) {
        this.fechaSalidaPelicula = fechaSalidaPelicula;
    }

    public void setUrlPosterPelicula(String urlPosterPelicula) {
        this.urlPosterPelicula = urlPosterPelicula;
    }
}
