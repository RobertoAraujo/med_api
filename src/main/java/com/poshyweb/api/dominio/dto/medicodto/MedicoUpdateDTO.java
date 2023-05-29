package com.poshyweb.api.dominio.dto.medicodto;

import com.poshyweb.api.dominio.dto.endereco.EnderecoDTO;
import jakarta.validation.constraints.NotNull;

public record MedicoUpdateDTO(
        @NotNull
        Long id,
        String nome,
        String telefone,
        EnderecoDTO enderecoDTO) {

}
