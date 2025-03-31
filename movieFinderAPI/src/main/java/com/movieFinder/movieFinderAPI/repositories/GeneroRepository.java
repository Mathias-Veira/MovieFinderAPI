package com.movieFinder.movieFinderAPI.repositories;

import com.movieFinder.movieFinderAPI.models.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeneroRepository extends JpaRepository<Genero,Integer> {
    @Query("SELECT G\n" +
            "FROM Genero G INNER JOIN PeliculaGenero PG\n" +
            "ON G.idGenero = PG.idGenero\n" +
            "WHERE PG.idPelicula = :id_pelicula")
    List<Genero> obtenerGeneros(@Param("id_pelicula") int idPelicula);
}
