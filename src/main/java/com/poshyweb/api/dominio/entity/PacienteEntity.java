package com.poshyweb.api.dominio.entity;

public record PacienteEntity (String nome, String email, String telefone, String cpf, EnderecoEntity endereco){
}
