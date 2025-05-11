package com.movieFinder.movieFinderAPI.repositories;

import com.movieFinder.movieFinderAPI.models.Historial;
import com.movieFinder.movieFinderAPI.models.HistorialPelicula;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistorialRepository extends JpaRepository<Historial,Integer> {
    @Query("SELECT NEW com.movieFinder.movieFinderAPI.models.HistorialPelicula(H.idHistorial,P.idPelicula,P.tituloPelicula,P.tituloOriginalPelicula,P.sinopsisPelicula,P.fechaSalidaPelicula,P.urlPosterPelicula,H.fechaVisto)FROM Historial H INNER JOIN Pelicula P\n" +
            "ON H.idPelicula = P.idPelicula INNER JOIN Usuario U\n" +
            "ON H.idUsuario = U.idUsuario\n" +
            "WHERE U.idUsuario = :id_usuario ")
    List<HistorialPelicula> obtenerHistorialPelicula(@Param("id_usuario") int idUsuario);
    @Modifying(clearAutomatically=true, flushAutomatically=true)
    @Transactional
    @Query("DELETE FROM Historial WHERE idUsuario = :id_usuario AND idPelicula = :id_pelicula")
    void eliminarPeliculaHistorial(@Param("id_usuario") int idUsuario,@Param("id_pelicula") int idPelicula);

    @Query("SELECT H FROM Historial H INNER JOIN Pelicula P\n" +
            "ON H.idPelicula = P.idPelicula INNER JOIN Usuario U\n" +
            "ON H.idUsuario = U.idUsuario\n" +
            "WHERE U.idUsuario = :id_usuario AND P.idPelicula = :id_pelicula")
    Historial obtenerPeliculaHistorial(@Param("id_usuario") int idUsuario,@Param("id_pelicula") int idPelicula);
}
