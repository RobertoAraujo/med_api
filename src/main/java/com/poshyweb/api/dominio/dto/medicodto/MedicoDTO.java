package com.poshyweb.api.dominio.dto.medicodto;

import com.poshyweb.api.constants.Expecializacao;
import com.poshyweb.api.dominio.dto.endereco.EnderecoDTO;
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
        @NotBlank @Pattern(regexp = "^\\(?[1-9]{2}\\)? ?(?:[2-8]|9[1-9])[0-9]{3}\\-?[0-9]{4}$")
        String telefone,
        @NotNull
        Expecializacao expecializacao,
        @NotBlank @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull @Valid
        EnderecoDTO endereco) {
}
