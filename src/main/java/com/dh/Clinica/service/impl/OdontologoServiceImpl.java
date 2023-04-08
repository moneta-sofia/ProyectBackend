package com.dh.Clinica.service.impl;

import com.dh.Clinica.dto.OdontologoDTO;
import com.dh.Clinica.exceptions.BadRequestException;
import com.dh.Clinica.model.Odontologo;
import com.dh.Clinica.repository.IOdontologoRepository;
import com.dh.Clinica.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class OdontologoServiceImpl implements IOdontologoService {
    private static final Logger logger = Logger.getLogger(OdontologoServiceImpl.class);
    @Autowired
    IOdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;


    @Override
    public void guardarOdontologo(OdontologoDTO odontologoDTO) throws BadRequestException {
        if (buscarPorMatricula(odontologoDTO.getMatricula()) == null){
            Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
            odontologoRepository.save(odontologo);
            logger.info("El odontologo se ha guardado correctamente");
        } else {
            logger.error("El odontologo no se ha podido guardar");
            throw new BadRequestException("Ya existe un odontologo con esa matricula");
        }

    }

    @Override
    public OdontologoDTO buscarOdontologo(Long id) {
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        OdontologoDTO odontologoDTO = null;
        if (odontologo.isPresent()) {
            odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
            logger.info("Se ha encontrado al odontologo buscado");
        }
        return odontologoDTO;
    }

    @Override
    public Set<OdontologoDTO> buscarOdontologos() {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        Set<OdontologoDTO> odontologoDTOS = new HashSet<>();

        for (Odontologo odontologo : odontologos) {
            odontologoDTOS.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }
        logger.info("Se han encontrado a los odontologos correctamente");
        return odontologoDTOS;
    }

    @Override
    public void actualizarOdontologo(OdontologoDTO odontologoDTO) throws BadRequestException {
        guardarOdontologo(odontologoDTO);
        logger.info("Se ha actualizado el odontologo correctamente");
    }

    @Override
    public void eliminarOdontologo(Long id) {
        odontologoRepository.deleteById(id);
        logger.info("Se ha eliminado al odontologo correctamente");
    }

    public OdontologoDTO buscarPorMatricula(String matricula) {
        Set<OdontologoDTO> odontologos = buscarOdontologos();
        OdontologoDTO resultado= null;
        for(OdontologoDTO odontologo : odontologos){
            if( odontologo.getMatricula() == matricula){
                resultado = odontologo;
            }
        }
        return resultado;
    }
}
