package com.dh.Clinica.service;

import com.dh.Clinica.dto.PacienteDTO;
import com.dh.Clinica.exceptions.BadRequestException;

import java.util.Set;

public interface IPacienteService {
    void guardarPaciente(PacienteDTO pacienteDTO) throws BadRequestException;
    PacienteDTO buscarPaciente(Long id);
    Set<PacienteDTO> buscarPacientes();
    void actualizarPaciente(PacienteDTO pacienteDTO) throws BadRequestException;
    void eliminarPaciente(Long id);
}
