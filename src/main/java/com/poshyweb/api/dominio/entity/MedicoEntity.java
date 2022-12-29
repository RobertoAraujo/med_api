package com.poshyweb.api.dominio.entity;

import com.poshyweb.api.constants.Expecializacao;

public record MedicoEntity (String nome, String email, String telefone, Expecializacao expecializacao, String crm, EnderecoEntity endereco){
}
