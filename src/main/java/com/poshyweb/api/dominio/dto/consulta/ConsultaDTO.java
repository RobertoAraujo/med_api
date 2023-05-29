package com.poshyweb.api.dominio.dto.consulta;

import com.poshyweb.api.constants.Expecializacao;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ConsultaDTO(
        @NotNull
        Long idMedico,
        @NotNull
        Long idPaciente,
        Long aLong, @NotNull
        @Future
        LocalDateTime data,
        Expecializacao expecializacao) {}
