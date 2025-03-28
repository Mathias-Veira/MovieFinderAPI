package com.movieFinder.movieFinderAPI.repositories;



import com.movieFinder.movieFinderAPI.models.Valorar;

import com.movieFinder.movieFinderAPI.models.ValorarPelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ValorarRepository extends JpaRepository<Valorar,Integer> {
    @Query("SELECT NEW com.movieFinder.movieFinderAPI.models.ValorarPelicula(V.idValorar,V.idPelicula,U.idUsuario,U.nombreUsuario,V.valoracion,V.fechaValoracion,V.textoValoracion) FROM Valorar V INNER JOIN Usuario U ON V.idUsuario = U.idUsuario WHERE V.idPelicula = :id_pelicula")
    List<ValorarPelicula> obtenerValoracionesPelis(@Param("id_pelicula") int idPelicula);
}
