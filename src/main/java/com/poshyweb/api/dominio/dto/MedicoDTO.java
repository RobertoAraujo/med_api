package com.poshyweb.api.dominio.dto;

import com.poshyweb.api.constants.Expecializacao;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record MedicoDTO(
        @NotBlank
        String nome,
        @NotBlank @Email
        String email,
        String telefone,
        @NotNull
        Expecializacao expecializacao,
        @NotBlank @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull @Valid
        EnderecoDTO endereco) {
}
