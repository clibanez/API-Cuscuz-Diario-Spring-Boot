package com.clibanez.cuscuzdiario.repository;



import java.util.Optional;

import com.clibanez.cuscuzdiario.domian.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

    Optional<Usuario> findByEmail(String email);
    
}
