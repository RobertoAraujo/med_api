package com.poshyweb.api.dominio.dto;

import com.poshyweb.api.constants.Expecializacao;
import com.poshyweb.api.dominio.entity.MedicoEntity;

public record MedicoListDTO(String nome, String email, String crm, Expecializacao expecializacao) {
    public MedicoListDTO (MedicoEntity medicoEntity){
        this(medicoEntity.getNome(), medicoEntity.getEmail(), medicoEntity.getCrm(), medicoEntity.getExpecializacao());
    }
}
