package com.dh.Clinica.service;

import com.dh.Clinica.dto.OdontologoDTO;
import com.dh.Clinica.exceptions.BadRequestException;

import java.util.Set;

public interface IOdontologoService {
    void guardarOdontologo(OdontologoDTO odontologoDTO) throws BadRequestException;
    OdontologoDTO buscarOdontologo(Long id);
    Set<OdontologoDTO> buscarOdontologos();
    void actualizarOdontologo(OdontologoDTO odontologoDTO) throws BadRequestException;
    void eliminarOdontologo(Long id);
}
