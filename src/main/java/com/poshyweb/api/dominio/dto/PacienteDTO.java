package com.poshyweb.api.dominio.dto;

public record PacienteDTO(String nome, String email, String telefone, String cpf, EnderecoDTO endereco){
}
