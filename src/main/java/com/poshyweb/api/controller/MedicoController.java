package com.poshyweb.api.controller;

import com.poshyweb.api.dominio.entity.MedicoEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/medico")
public class MedicoController {

    @PostMapping(value = "cadastrar")
    public void cadastrar(@RequestBody MedicoEntity medicoEntity){
        System.out.println(medicoEntity);
    }
}
