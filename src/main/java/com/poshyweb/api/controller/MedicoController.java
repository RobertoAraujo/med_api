package com.poshyweb.api.controller;

import com.poshyweb.api.dominio.dto.MedicoDTO;
import com.poshyweb.api.dominio.dto.MedicoListDTO;
import com.poshyweb.api.dominio.entity.MedicoEntity;
import com.poshyweb.api.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/medico")
public class MedicoController {
    @Autowired
    private MedicoService service;

    @PostMapping(value = "/insert")
    public ResponseEntity<MedicoEntity> cadastrar(@RequestBody @Valid MedicoDTO medicoDTO) {
        try {
            MedicoEntity medicoEntity = service.saveMedico(medicoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(medicoEntity);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(value = "listAll")
    public ResponseEntity<List<MedicoListDTO>> listAll() {
        try{
            List<MedicoListDTO> listAllMedicos = service.getAll().stream().toList();
            return ResponseEntity.ok().body(listAllMedicos);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

}
