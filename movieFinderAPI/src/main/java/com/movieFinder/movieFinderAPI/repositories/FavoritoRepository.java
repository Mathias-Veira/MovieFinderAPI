package com.movieFinder.movieFinderAPI.repositories;

import com.movieFinder.movieFinderAPI.models.Favorito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoritoRepository extends JpaRepository<Favorito,Integer> {
    @Query("SELECT f FROM Favorito f WHERE f.idUsuario = :id_usuario")
    List<Favorito> obtenerListaFavoritos (@Param("id_usuario")int idUsuario);
}
