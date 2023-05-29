package com.poshyweb.api.dominio.repository;

import com.poshyweb.api.dominio.entity.PacienteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<PacienteEntity, Long> {
    @Query("FROM PacienteEntity p WHERE LOWER(p.nome) like %:nome% ")
    Page<PacienteEntity> search(@Param("nome") String nome, Pageable pageable);

}
