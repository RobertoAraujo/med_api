package com.poshyweb.api.dominio.dto.pacientedto;

import com.poshyweb.api.dominio.entity.PacienteEntity;
import org.springframework.data.domain.Pageable;

public record PacienteListDTO(Long id, String nome, String email, String telefone) {
    public PacienteListDTO(PacienteEntity pacienteEntity) {
        this(pacienteEntity.getId(), pacienteEntity.getNome(), pacienteEntity.getEmail(), pacienteEntity.getTelefone());
    }
}
