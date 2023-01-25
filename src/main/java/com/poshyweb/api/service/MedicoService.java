package com.poshyweb.api.service;

import com.poshyweb.api.dominio.dto.MedicoDTO;
import com.poshyweb.api.dominio.dto.MedicoListDTO;
import com.poshyweb.api.dominio.entity.MedicoEntity;
import com.poshyweb.api.dominio.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository repository;

    public MedicoEntity saveMedico(MedicoDTO medicoDTO) {
        MedicoEntity medico = repository.save(new MedicoEntity(medicoDTO));
        return medico;
    }
    public List<MedicoListDTO> getAll() {
        List<MedicoListDTO> medicos = repository.findAll().stream().map(MedicoListDTO::new).toList();
        return medicos;
    }
}
