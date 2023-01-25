package com.poshyweb.api.dominio.dto;

import com.poshyweb.api.dominio.entity.PacienteEntity;

public record PacienteListDTO(String nome, String email, String telefone) {
    public PacienteListDTO(PacienteEntity pacienteEntity) {
        this(pacienteEntity.getNome(), pacienteEntity.getEmail(), pacienteEntity.getTelefone());
    }
}
