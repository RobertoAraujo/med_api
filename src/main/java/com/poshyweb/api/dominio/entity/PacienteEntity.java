package com.poshyweb.api.dominio.entity;

import com.poshyweb.api.dominio.dto.PacienteDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "paciente")
@Data
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
}
