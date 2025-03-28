package com.movieFinder.movieFinderAPI.repositories;

import com.movieFinder.movieFinderAPI.models.Historial;
import com.movieFinder.movieFinderAPI.models.HistorialPelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistorialRepository extends JpaRepository<Historial,Integer> {
    @Query("SELECT h FROM Historial h WHERE h.idUsuario = :id_usuario")
    List<Historial> obtenerListaHistorial(@Param("id_usuario") int idUsuario);
    @Query("SELECT NEW com.movieFinder.movieFinderAPI.models.HistorialPelicula(P.idPelicula,P.tituloPelicula,P.tituloOriginalPelicula,P.sinopsisPelicula,P.fechaSalidaPelicula,P.urlPosterPelicula,H.fechaVisto)FROM Historial H INNER JOIN Pelicula P\n" +
            "ON H.idPelicula = P.idPelicula INNER JOIN Usuario U\n" +
            "ON H.idUsuario = U.idUsuario\n" +
            "WHERE U.idUsuario = :id_usuario ")
    List<HistorialPelicula> obtenerHistorialPelicula(@Param("id_usuario") int idUsuario);
}
