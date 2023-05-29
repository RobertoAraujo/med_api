package com.poshyweb.api.service;

import com.poshyweb.api.dominio.dto.consulta.CancelamentoConsultaDto;
import com.poshyweb.api.dominio.dto.consulta.ConsultaDTO;
import com.poshyweb.api.dominio.entity.ConsultaEntity;
import com.poshyweb.api.dominio.entity.MedicoEntity;
import com.poshyweb.api.dominio.repository.ConsultaRepository;
import com.poshyweb.api.dominio.repository.MedicoRepository;
import com.poshyweb.api.dominio.repository.PacienteRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public ConsultaEntity saveSchedule(ConsultaDTO dto) {
        if (!pacienteRepository.existsById(dto.idPaciente())) {
            throw new ValidationException("id do paciente não existe na base!");
        }
        if (dto.idMedico() != null && !medicoRepository.existsById(dto.idMedico())) {
            throw new ValidationException("id do medico não existe na base!");
        }

        var pacienteId = pacienteRepository.findById(dto.idPaciente()).get();
        var medicoid = escolherMedcio(dto);
        var consulta = new ConsultaEntity(null, medicoid, pacienteId, dto.data(), dto.expecializacao());

        return consultaRepository.save(consulta);
    }

    private MedicoEntity escolherMedcio(ConsultaDTO dto) {
        if (dto.idMedico() != null) {
            return medicoRepository.getReferenceById(dto.idMedico());
        }
        if (dto.expecializacao() == null) {
            throw new ValidationException("Expecialidade tem que ser ecolhida");
        }
        medicoRepository.ChooseFreeAleatyorioDoctorOnDate(dto.expecializacao(), dto.data());
        return null;
    }

    public void cancelar(CancelamentoConsultaDto cancelamentoConsultaDto) {
        if (!consultaRepository.existsById(cancelamentoConsultaDto.idConsulta())) {
            throw new ValidationException("Id da consulta informado não existe!");
        }

        var consulta = consultaRepository.getReferenceById(cancelamentoConsultaDto.idConsulta());
        consulta.cancelar(cancelamentoConsultaDto.motivo());
    }

}
