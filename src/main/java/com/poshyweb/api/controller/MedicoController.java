package com.poshyweb.api.controller;

import com.poshyweb.api.dominio.dto.medicodto.MedicoDTO;
import com.poshyweb.api.dominio.dto.medicodto.MedicoListDTO;
import com.poshyweb.api.dominio.dto.medicodto.MedicoUpdateDTO;
import com.poshyweb.api.dominio.entity.MedicoEntity;
import com.poshyweb.api.service.MedicoService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/medico")
public class MedicoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MedicoController.class.getName());
    @Autowired
    private MedicoService service;

    @PostMapping(path = "/insert")
    public ResponseEntity<MedicoEntity> cadastrar(@RequestBody @Valid MedicoDTO medicoDTO) {
        try {
            MedicoEntity medicoEntity = service.saveMedico(medicoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(medicoEntity);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(path = "/listAll")
    public ResponseEntity<List<MedicoListDTO>> listAll() {
        try {
            List<MedicoListDTO> listAllMedicos = service.getAll().stream().toList();
            return ResponseEntity.ok().body(listAllMedicos);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<String> updateMedico(@RequestBody @Valid MedicoUpdateDTO medicoUpdateDTO) {
        try {
            MedicoUpdateDTO medico = service.updateMedico(medicoUpdateDTO);
            return ResponseEntity.ok().body("Atualizado com sucesso! ");
        } catch (Exception e) {
            throw new RuntimeException("Dados não atualizado! ", e.getCause());
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deletMedico(@PathVariable Long id) {
        service.deletMedico(id);
        return ResponseEntity.ok().body("Deletado com sucesso! ");
    }
}
