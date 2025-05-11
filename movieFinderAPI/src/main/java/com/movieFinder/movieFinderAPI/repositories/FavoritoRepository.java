package com.movieFinder.movieFinderAPI.repositories;

import com.movieFinder.movieFinderAPI.models.Favorito;
import com.movieFinder.movieFinderAPI.models.FavoritoPelicula;
import com.movieFinder.movieFinderAPI.models.Historial;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoritoRepository extends JpaRepository<Favorito,Integer> {
    @Query("SELECT NEW com.movieFinder.movieFinderAPI.models.FavoritoPelicula(F.idFavorito,P.idPelicula,P.tituloPelicula,P.tituloOriginalPelicula,P.sinopsisPelicula,P.fechaSalidaPelicula,P.urlPosterPelicula)FROM Favorito F INNER JOIN Pelicula P\n" +
            "ON F.idPelicula = P.idPelicula INNER JOIN Usuario U\n" +
            "ON F.idUsuario = U.idUsuario\n"+
            "WHERE U.idUsuario = :id_usuario")
    List<FavoritoPelicula> obtenerListaFavoritos (@Param("id_usuario")int idUsuario);

    @Query("SELECT F FROM Favorito F INNER JOIN Pelicula P\n" +
            "ON F.idPelicula = P.idPelicula INNER JOIN Usuario U\n" +
            "ON F.idUsuario = U.idUsuario\n" +
            "WHERE U.idUsuario = :id_usuario AND P.idPelicula = :id_pelicula")
    Favorito obtenerPeliculaFavorito(@Param("id_usuario") int idUsuario, @Param("id_pelicula") int idPelicula);
    @Modifying(clearAutomatically=true, flushAutomatically=true)
    @Transactional
    @Query("DELETE FROM Favorito WHERE idUsuario = :id_usuario AND idPelicula = :id_pelicula")
    void eliminarPeliculaFavorito(@Param("id_usuario") int idUsuario,@Param("id_pelicula") int idPelicula);
}
