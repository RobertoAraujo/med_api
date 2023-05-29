package com.poshyweb.api.controller;

import com.poshyweb.api.dominio.dto.pacientedto.PacienteDTO;
import com.poshyweb.api.dominio.dto.pacientedto.PacienteListDTO;
import com.poshyweb.api.dominio.dto.pacientedto.PacienteUpdateDTO;
import com.poshyweb.api.dominio.entity.PacienteEntity;
import com.poshyweb.api.service.PacienteService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequestMapping(value = "/pacientes")
public class PacienteController {
    public static final Logger LOGGER =  LoggerFactory.getLogger(PacienteController.class.getName());
    @Autowired
    private PacienteService service;

    @PostMapping(value = "/insert")
    public PacienteEntity cadastrar(@RequestBody PacienteDTO pacienteDTO) {
        PacienteEntity pacienteEntity = service.savePaciente(pacienteDTO);
        return pacienteEntity;
    }

    @GetMapping(value = "/listAll")
    public ResponseEntity<Page<PacienteEntity>> listAll() {
        Page<PacienteEntity> all = service.findAll();
        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/buscar")
    public Page<PacienteEntity> search(
            @RequestParam("nome") String nome,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "5") int size) {
        return service.search(nome, page, size);
    }


    @PutMapping(path = "/update/{id}")
    public ResponseEntity<String> updatePaciente(@RequestBody @Valid PacienteUpdateDTO pacienteUpdateDTO) {
        try {
            PacienteUpdateDTO paciente = service.updatePaciente(pacienteUpdateDTO);
            return ResponseEntity.ok().body(" Atualizado com sucesso! ");
        }catch (Exception e){
            throw new RuntimeException("Id inexistente na base! ");
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity deletePaciente(@PathVariable Long id) {
        try {
            service.delete(id);
            LOGGER.info("Deletado com sucesso! {}", id);
            return ResponseEntity.notFound().build();
        }catch (HttpClientErrorException.BadRequest e){
            throw new RuntimeException("ID não encontrado! ", e.getCause());
        }
    }
}
