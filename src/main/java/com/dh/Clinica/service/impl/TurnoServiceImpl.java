package com.dh.Clinica.service.impl;

import com.dh.Clinica.dto.TurnoDTO;
import com.dh.Clinica.model.Odontologo;
import com.dh.Clinica.model.Paciente;
import com.dh.Clinica.model.Turno;
import com.dh.Clinica.repository.ITurnoRepository;
import com.dh.Clinica.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
public class TurnoServiceImpl implements ITurnoService {

    private static final Logger logger = Logger.getLogger(TurnoServiceImpl.class);

    @Autowired
    ObjectMapper mapper;

    @Autowired
    PacienteServiceImpl pacienteService;
    @Autowired
    OdontologoServiceImpl odontologoService;

    @Autowired
    ITurnoRepository turnoRepository;

    @Override
    public void guardarTurno(TurnoDTO turnoDTO) {
        turnoRepository.save(mapper.convertValue(turnoDTO, Turno.class));
        logger.info("El turno se ha guardado correctamente");
    }

    @Override
    public TurnoDTO buscarTurno(Long id) {
        Optional<Turno> turnoEncontrado = turnoRepository.findById(id);
        TurnoDTO turnoDTOmappeado = mapper.convertValue(turnoEncontrado, TurnoDTO.class);
        logger.info("Se ha encontrado al turno con id "+ id);
        return turnoDTOmappeado;
    }

    @Override
    public Set<TurnoDTO> buscarTurnos() {
        List<Turno> turnos = turnoRepository.findAll();
        Set<TurnoDTO> result = new HashSet<>();
        for (Turno turno : turnos){
            result.add(mapper.convertValue(turno,TurnoDTO.class));
        }
        logger.info("Se ha encontrado los turnos");
        return result;
    }

    @Override
    public void actualizarTurno(TurnoDTO turnoDTO) {
        guardarTurno(turnoDTO);
        logger.info("Se ha actualizado el turno");
    }

    @Override
    public void eliminarTurno(Long id) {
        turnoRepository.deleteById(id);
        logger.info("Se ha eliminado correctamente el turno");
    }

    public void setPacienteExistente(Long idPaciente, TurnoDTO turnoDTO) {
        Paciente pacienteMappeado = mapper.convertValue(pacienteService.buscarPaciente(idPaciente), Paciente.class);
        turnoDTO.setPaciente(pacienteMappeado);
    }

    public void setOdontologoExistente(Long idOdontologo, TurnoDTO turnoDTO) {
        Odontologo odontologoMappeado = mapper.convertValue(odontologoService.buscarOdontologo(idOdontologo), Odontologo.class);
        turnoDTO.setOdontologo(odontologoMappeado);
    }
}
