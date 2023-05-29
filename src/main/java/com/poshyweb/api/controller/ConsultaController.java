package com.poshyweb.api.controller;

import com.poshyweb.api.dominio.dto.consulta.CancelamentoConsultaDto;
import com.poshyweb.api.dominio.dto.consulta.ConsultaDTO;
import com.poshyweb.api.service.ConsultaService;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/consulta")
public class ConsultaController {
    @Autowired
    private ConsultaService service;

    @PostMapping (path = "/insert")
    public ResponseEntity insertConsulta(@RequestBody @Valid ConsultaDTO consultaDTO){
        return ResponseEntity.ok(new ConsultaDTO(
                null, consultaDTO.idMedico(), consultaDTO.idPaciente(),
                consultaDTO.data(), consultaDTO.expecializacao()));
    }
    @GetMapping(path = "/lista")
    public ResponseEntity<String> consultSchedule(){
        return ResponseEntity.ok().body("");
    }

    @DeleteMapping
    public ResponseEntity cancelar(@RequestBody @Valid CancelamentoConsultaDto cancelamentoConsultaDto) {
        service.cancelar(cancelamentoConsultaDto);
        return ResponseEntity.noContent().build();
    }
}
