package com.poshyweb.api.dominio.entity;

import com.poshyweb.api.dominio.dto.pacientedto.PacienteDTO;
import com.poshyweb.api.dominio.dto.pacientedto.PacienteUpdateDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "paciente")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PacienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    @Embedded
    private EnderecoEntity endereco;

    public PacienteEntity(PacienteDTO pacienteDTO) {
        this.nome = pacienteDTO.nome();
        this.email = pacienteDTO.email();
        this.telefone = pacienteDTO.telefone();
        this.cpf = pacienteDTO.cpf();
        this.endereco = new EnderecoEntity(pacienteDTO.endereco());
    }

    public PacienteUpdateDTO updateInformation(PacienteUpdateDTO pacienteUpdateDTO) {
        this.id = pacienteUpdateDTO.id();
        if (pacienteUpdateDTO.nome() != null) {
            this.nome = pacienteUpdateDTO.nome();
        }
        if (pacienteUpdateDTO.email() != null) {
            this.email = pacienteUpdateDTO.email();
        }
        if (pacienteUpdateDTO.telefone() != null) {
            this.telefone = pacienteUpdateDTO.telefone();
        }
        if (pacienteUpdateDTO.cpf() != null) {
            this.cpf = pacienteUpdateDTO.cpf();
        }
        if (pacienteUpdateDTO.enderecoDTO() != null) {
            this.endereco.updateInformation(pacienteUpdateDTO.enderecoDTO());
        }
        return pacienteUpdateDTO;
    }
}
