package com.dh.Clinica.service.impl;

import com.dh.Clinica.dto.PacienteDTO;
import com.dh.Clinica.exceptions.BadRequestException;
import com.dh.Clinica.model.Paciente;
import com.dh.Clinica.repository.IPacienteRepository;
import com.dh.Clinica.service.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
public class PacienteServiceImpl implements IPacienteService {

    private static final Logger logger = Logger.getLogger(PacienteServiceImpl.class);
    @Autowired
    IPacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void guardarPaciente(PacienteDTO pacienteDTO) throws BadRequestException {
        if (buscarPorDni(pacienteDTO.getDni()) == null) {
            Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
            pacienteRepository.save(paciente);
            logger.info("Se ha guardado el paciente correctamente");
        }else {
            logger.error("No se ha porido crear al paciente");
            throw new BadRequestException("Ya existe un paciente con ese dni");
        }

    }

    @Override
    public PacienteDTO buscarPaciente(Long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        PacienteDTO pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
        logger.info("Se ha encontrado al paciente con id: " + id);
        return pacienteDTO;
    }

    @Override
    public Set<PacienteDTO> buscarPacientes() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        Set<PacienteDTO> pacientesDTO = new HashSet<>();
        for (Paciente paciente: pacientes) {
            pacientesDTO.add(mapper.convertValue(paciente, PacienteDTO.class));
        }
        logger.info("Se han encontrado a los pacientes correctamente");
        return pacientesDTO;
    }

    @Override
    public void actualizarPaciente(PacienteDTO pacienteDTO) throws BadRequestException {
        guardarPaciente(pacienteDTO);
        logger.info("Se ha actualizado el paciente correctamente");

    }

    @Override
    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
        logger.info("El paciente ha sido eliminado correctamente");
    }

    public PacienteDTO buscarPorDni(String dni) {
        Set<PacienteDTO> pacientes = buscarPacientes();
        PacienteDTO resultado= null;
        for(PacienteDTO paciente : pacientes) {
            if( paciente.getDni() == dni){
                resultado = paciente;
            }
        }

        return resultado;
    }
}
