package com.cami_dev.gaceta_ingles.repositories;

import com.cami_dev.gaceta_ingles.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    //JPA crea la funcion automaticamente con solo leer el nombre del metodo
    Optional<Usuario> findByEmail(String email);

    boolean existsByEmail(String email);
}
