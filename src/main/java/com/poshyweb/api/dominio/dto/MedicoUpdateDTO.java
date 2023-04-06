package com.poshyweb.api.dominio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MedicoUpdateDTO(
        @NotNull
        Long id,
        String nome,
        String telefone,
        EnderecoDTO enderecoDTO) {

}
