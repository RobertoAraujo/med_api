package com.poshyweb.api.dominio.dto.consulta;

import com.poshyweb.api.constants.MotivoCancelamento;
import jakarta.validation.constraints.NotNull;

public record CancelamentoConsultaDto(
        @NotNull
        Long idConsulta,

        @NotNull
        MotivoCancelamento motivo) { }
