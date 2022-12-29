package com.poshyweb.api.dominio.repository;

import com.poshyweb.api.dominio.dto.MedicoDTO;
import com.poshyweb.api.dominio.entity.MedicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicoRepository extends JpaRepository<MedicoEntity, Long> {
    List<MedicoEntity> findAll();
}
