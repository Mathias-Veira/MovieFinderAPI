package com.movieFinder.movieFinderAPI.repositories;

import com.movieFinder.movieFinderAPI.models.Favorito;
import com.movieFinder.movieFinderAPI.models.FavoritoPelicula;
import org.springframework.data.jpa.repository.JpaRepository;
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
}
