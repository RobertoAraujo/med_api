package com.poshyweb.api.service;

import com.poshyweb.api.dominio.dto.PacienteDTO;
import com.poshyweb.api.dominio.entity.PacienteEntity;
import com.poshyweb.api.dominio.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository repository;

    public PacienteEntity savePaciente(PacienteDTO pacienteDTO) {
        PacienteEntity savePaciente = repository.save(new PacienteEntity(pacienteDTO));
        return savePaciente;
    }

    public List<PacienteEntity> listAll() {
        List<PacienteEntity> listPacietes = repository.findAll();
        return listPacietes;
    }
}
