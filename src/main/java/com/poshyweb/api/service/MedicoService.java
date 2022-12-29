package com.poshyweb.api.service;

import com.poshyweb.api.controller.MedicoController;

import java.util.Objects;
import java.util.Optional;

public class MedicoService {

    public Optional<MedicoController> getId(Long id){
        if (Objects.equals(id, id)){
            return null;// repository.findById(id);
        }
        return null;
    }
    public MedicoController saveMedico(MedicoController medico){
        if (medico != null){
            return null;// repository.save(medico);
        }
        return null;
    }
}
