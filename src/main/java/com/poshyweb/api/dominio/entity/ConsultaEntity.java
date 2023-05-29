package com.poshyweb.api.dominio.entity;

import com.poshyweb.api.constants.Expecializacao;
import com.poshyweb.api.constants.MotivoCancelamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "consulta")
@Table(name = "consulta")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ConsultaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_medico")
    private MedicoEntity idMedico;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private PacienteEntity idPaciente;

    private LocalDateTime data;

    @Column(name = "motivo_cancelamento")
    @Enumerated(EnumType.STRING)
    private MotivoCancelamento motivoCancelamento;

    public ConsultaEntity(Long id, MedicoEntity medicoid, PacienteEntity pacienteId, LocalDateTime data, Expecializacao expecializacao) {
    }

    public void cancelar(MotivoCancelamento motivo) {
        this.motivoCancelamento = motivo;
    }

}
