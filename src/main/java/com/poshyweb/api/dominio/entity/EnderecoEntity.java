package com.poshyweb.api.dominio.entity;

import com.poshyweb.api.dominio.dto.EnderecoDTO;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoEntity {
    private String longradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String numero;
    private String complemento;

    public EnderecoEntity(EnderecoDTO enderecoDTO) {
        this.longradouro = enderecoDTO.longradouro();
        this.cep = enderecoDTO.cep();
        this.bairro = enderecoDTO.bairro();
        this.cidade = enderecoDTO.cidade();
        this.uf = enderecoDTO.uf();
        this.numero = enderecoDTO.numero();
        this.complemento = enderecoDTO.complemento();
    }

    public void updateInformation(EnderecoDTO enderecoDTO) {
        if (enderecoDTO.longradouro() != null){
            this.longradouro = enderecoDTO.longradouro();
        }
        if (enderecoDTO.cep() != null){
            this.cep = enderecoDTO.cep();
        }
        if (enderecoDTO.bairro() != null){
            this.bairro = enderecoDTO.bairro();
        }
        if (enderecoDTO.cidade() != null){
            this.cidade = enderecoDTO.cidade();
        }
        if (enderecoDTO.uf() != null){
            this.uf = enderecoDTO.uf();
        }
        if (enderecoDTO.numero() != null){
            this.numero = enderecoDTO.numero();
        }
        if (enderecoDTO.complemento() != null){
            this.complemento = enderecoDTO.complemento();
        }
    }
}
