package com.poshyweb.api.dominio.dto.pacientedto;

import com.poshyweb.api.dominio.dto.endereco.EnderecoDTO;
import jakarta.validation.constraints.NotNull;

public record PacienteUpdateDTO(
        @NotNull
        Long id,
        String nome,
        String email,
        String telefone,
        String cpf,
        EnderecoDTO enderecoDTO) {
}
