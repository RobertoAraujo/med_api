package com.poshyweb.api.controller;

import com.poshyweb.api.dominio.entity.PacienteEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pacientes")
public class PacienteController {
    @PostMapping(value = "/cadastrar")
    public void cadastrar(@RequestBody PacienteEntity dados) {
        System.out.println("dados recebido: " +dados);
    }

}
