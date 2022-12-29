package com.poshyweb.api.controller;

import com.poshyweb.api.dominio.dto.MedicoDTO;
import com.poshyweb.api.dominio.entity.MedicoEntity;
import com.poshyweb.api.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/medico")
public class MedicoController {
    @Autowired
    private MedicoService service;

    @PostMapping(value = "/insert")
    public MedicoEntity cadastrar(@RequestBody MedicoDTO medicoDTO){
        return service.saveMedico(medicoDTO);
    }

    @GetMapping (value = "listAll")
    public List<MedicoEntity> listAll(){
        return service.getAll();
    }
}
