package com.movieFinder.movieFinderAPI.repositories;

import com.movieFinder.movieFinderAPI.models.PeliculaGenero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaGeneroRepository extends JpaRepository<PeliculaGenero,Integer> {
}
