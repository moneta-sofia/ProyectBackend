package com.dh.Clinica.service;

import com.dh.Clinica.dto.DomicilioDTO;

import java.util.Set;

public interface IDomicilioService {
    void guardarDomicilio(DomicilioDTO domicilioDTO);
    DomicilioDTO buscarDomicilio(Long id);
    Set<DomicilioDTO> buscarDomicilios();
    void actualizarDomicilio(DomicilioDTO domicilioDTO);
    void eliminarDomicilio(Long id);
}
