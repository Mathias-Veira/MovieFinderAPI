package com.movieFinder.movieFinderAPI.repositories;

import com.movieFinder.movieFinderAPI.models.Pelicula;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula,Integer> {
    Page<Pelicula> findAll(Pageable pageable);
    @Query("SELECT P\n" +
            "FROM Pelicula P INNER JOIN PeliculaGenero PG\n" +
            "ON P.idPelicula = PG.idPelicula INNER JOIN Genero G\n" +
            "ON PG.idGenero = G.idGenero\n" +
            "WHERE G.idGenero = :id_genero")
    Page<Pelicula> findMoviesByGenreId(@Param("id_genero") int idGenero,Pageable pageable);
    @Query("SELECT P FROM Pelicula P WHERE P.tituloPelicula like %:titulo%")
    Page<Pelicula> findMoviesByMovieName(@Param("titulo")String titulo,Pageable pageable);
}
