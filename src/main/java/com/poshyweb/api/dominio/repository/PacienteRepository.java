package com.poshyweb.api.dominio.repository;

import com.poshyweb.api.dominio.entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PacienteRepository extends JpaRepository<PacienteEntity, Long> {
}
