package com.poshyweb.api.dominio.dto;

import com.poshyweb.api.constants.Expecializacao;

public record MedicoDTO(String nome, String email, String telefone, Expecializacao expecializacao, String crm, EnderecoDTO endereco){
}
