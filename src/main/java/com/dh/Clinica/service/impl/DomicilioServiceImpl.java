package com.dh.Clinica.service.impl;

import com.dh.Clinica.dto.DomicilioDTO;
import com.dh.Clinica.model.Domicilio;
import com.dh.Clinica.repository.IDomicilioRepository;
import com.dh.Clinica.service.IDomicilioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
public class DomicilioServiceImpl implements IDomicilioService {
    private static final Logger logger = Logger.getLogger(DomicilioServiceImpl.class);
    @Autowired
    private IDomicilioRepository domicilioRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void guardarDomicilio(DomicilioDTO domicilioDTO) {
        Domicilio domicilio = mapper.convertValue(domicilioDTO, Domicilio.class);
        domicilioRepository.save(domicilio);
        logger.info("Se ha guardado el domicilio correctamente");

    }

    @Override
    public DomicilioDTO buscarDomicilio(Long id) {
        Optional<Domicilio> domicilio = domicilioRepository.findById(id);
        DomicilioDTO domicilioDTO = null;
        if (domicilio.isPresent()) {
            domicilioDTO = mapper.convertValue(domicilio, DomicilioDTO.class);
            logger.info("Se ha encontrado el domicilio correctamente");
        }
        return  domicilioDTO;
    }

    @Override
    public Set<DomicilioDTO> buscarDomicilios() {
        List<Domicilio> domicilios = domicilioRepository.findAll();
        Set<DomicilioDTO> domicilioDTOS = new HashSet<>();

        for (Domicilio domicilio : domicilios)
            domicilioDTOS.add(mapper.convertValue(domicilio, DomicilioDTO.class));

        logger.info("Se han encontrado los domicilios correctamente");
        return  domicilioDTOS;
    }

    @Override
    public void actualizarDomicilio(DomicilioDTO domicilioDTO) {
        guardarDomicilio(domicilioDTO);
        logger.info("Se ha actualizado el domicilio correctamente");

    }

    @Override
    public void eliminarDomicilio(Long id) {
        domicilioRepository.deleteById(id);
        logger.info("Se ha eliminado al domicilio correctamente");
    }
}
