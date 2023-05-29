package com.poshyweb.api.dominio.entity;

import com.poshyweb.api.constants.Expecializacao;
import com.poshyweb.api.dominio.dto.medicodto.MedicoDTO;
import com.poshyweb.api.dominio.dto.medicodto.MedicoUpdateDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "medico")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class MedicoEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    @Enumerated(EnumType.STRING)
    private Expecializacao expecializacao;
    private String crm;
    @Embedded
    private EnderecoEntity endereco;

    public MedicoEntity(MedicoDTO medicoDTO) {
        this.nome = medicoDTO.nome();
        this.email = medicoDTO.email();
        this.telefone = medicoDTO.telefone();
        this.expecializacao = medicoDTO.expecializacao();
        this.crm = medicoDTO.crm();
        this.endereco = new EnderecoEntity(medicoDTO.endereco());
    }
    public MedicoUpdateDTO updateInformation(MedicoUpdateDTO medicoUpdateDTO){
        this.id = medicoUpdateDTO.id();
        if (medicoUpdateDTO.nome() != null) {
            this.nome = medicoUpdateDTO.nome();

        } else if (medicoUpdateDTO.telefone() != null) {
            this.telefone = medicoUpdateDTO.telefone();

        }else if (medicoUpdateDTO.enderecoDTO() != null) {
            this.endereco.updateInformation(medicoUpdateDTO.enderecoDTO());

        }

        return medicoUpdateDTO;
    }
}
