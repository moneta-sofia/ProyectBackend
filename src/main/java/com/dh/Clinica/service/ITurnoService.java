package com.dh.Clinica.service;

import com.dh.Clinica.dto.TurnoDTO;

import java.util.Set;

public interface ITurnoService {
    void guardarTurno(TurnoDTO turnoDTO);
    TurnoDTO buscarTurno(Long id);
    Set<TurnoDTO> buscarTurnos();
    void actualizarTurno(TurnoDTO turnoDTO);
    void eliminarTurno(Long id);
    void setOdontologoExistente(Long idOdontologo, TurnoDTO turnoDTO);
    void setPacienteExistente(Long idPaciente, TurnoDTO turnoDTO);
}
