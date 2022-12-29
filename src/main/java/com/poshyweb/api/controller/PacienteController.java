package com.poshyweb.api.controller;

import com.poshyweb.api.dominio.dto.PacienteDTO;
import com.poshyweb.api.dominio.entity.PacienteEntity;
import com.poshyweb.api.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService service;

    @PostMapping(value = "/insert")
    public PacienteEntity cadastrar(@RequestBody PacienteDTO pacienteDTO) {
        PacienteEntity pacienteEntity = service.savePaciente(pacienteDTO);
        return pacienteEntity;
    }

    @GetMapping(value = "/listAll")
    public List<PacienteEntity> listAllPacientes() {
        List<PacienteEntity> listAllPaciente = service.listAll();
        return listAllPaciente;
    }

}
