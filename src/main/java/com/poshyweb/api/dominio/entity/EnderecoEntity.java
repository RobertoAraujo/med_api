package com.poshyweb.api.dominio.entity;

import com.poshyweb.api.dominio.dto.EnderecoDTO;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoEntity {
    private String longradouro;
    private String cep;
    private String cidade;
    private String uf;
    private String numero;
    private String complemento;

    public EnderecoEntity(EnderecoDTO enderecoDTO) {
        this.longradouro = enderecoDTO.longradouro();
        this.cep = enderecoDTO.cep();
        this.cidade = enderecoDTO.cidade();
        this.uf = enderecoDTO.uf();
        this.numero = enderecoDTO.numero();
        this.complemento = enderecoDTO.complemento();
    }
}
