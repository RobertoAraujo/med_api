package com.poshyweb.api.service;

import com.poshyweb.api.dominio.dto.pacientedto.PacienteDTO;
import com.poshyweb.api.dominio.dto.pacientedto.PacienteListDTO;
import com.poshyweb.api.dominio.dto.pacientedto.PacienteUpdateDTO;
import com.poshyweb.api.dominio.entity.PacienteEntity;
import com.poshyweb.api.dominio.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    public PacienteUpdateDTO updatePaciente(PacienteUpdateDTO pacienteUpdateDTO) {
        PacienteEntity paciente = repository.getReferenceById(pacienteUpdateDTO.id());
        return paciente.updateInformation(pacienteUpdateDTO);
    }

    public Page<PacienteEntity> search(String nome, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "nome");
        return repository.search(nome.toLowerCase(), pageRequest);
    }

    public Page<PacienteEntity> findAll() {
        int page = 0;
        int size = 5;
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "nome");
        return new PageImpl<>(repository.findAll(), pageRequest, size);
    }

    public void delete(Long id) {
        PacienteEntity paciente = repository.getReferenceById(id);
        if (paciente.getId() != null) {
            repository.deleteById(id);
        } else {
            System.out.println("Não encontrado!");
        }
    }
}
