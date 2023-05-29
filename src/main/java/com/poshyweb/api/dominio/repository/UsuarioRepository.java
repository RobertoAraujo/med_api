package com.poshyweb.api.dominio.repository;

import com.poshyweb.api.dominio.entity.UsuarioEntyti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntyti, Long> {
    UserDetails findByUsuario(String Login);
}
