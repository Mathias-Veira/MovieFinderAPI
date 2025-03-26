package com.movieFinder.movieFinderAPI.repositories;

import com.movieFinder.movieFinderAPI.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    /**
     * Este método permite obtener un usuario buscándolo por el nombre
     * @param name nombre de usuario a buscar
     * @return objeto Usuario
     */
    @Query("SELECT u FROM Usuario u WHERE u.nombreUsuario LIKE :nombre_usuario")
    Usuario findByName(@Param("nombre_usuario") String name);
}
