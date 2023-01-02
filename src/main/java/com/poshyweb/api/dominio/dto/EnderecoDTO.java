package com.poshyweb.api.dominio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record EnderecoDTO(
        @NotBlank
        String longradouro,
        @NotBlank
        String bairro,
        @NotBlank @Pattern(regexp = "\\d{8}")
        String cep,
        @NotBlank
        String cidade,
        @NotBlank
        String uf,

        String numero,

        String complemento) {

}
