package com.movieFinder.movieFinderAPI.repositories;

import com.movieFinder.movieFinderAPI.models.Pelicula;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula,Integer> {
    @Query("SELECT p FROM Pelicula p ORDER BY p.fechaSalidaPelicula DESC")
    List<Pelicula> findMoviesByDate(PageRequest pageable);
    @Query("SELECT P\n" +
            "FROM Pelicula P INNER JOIN PeliculaGenero PG\n" +
            "ON P.idPelicula = PG.idPelicula INNER JOIN Genero G\n" +
            "ON PG.idGenero = G.idGenero\n" +
            "WHERE G.idGenero = :id_genero")
    List<Pelicula> findMoviesByGenreId(@Param("id_genero") int idGenero);
}
