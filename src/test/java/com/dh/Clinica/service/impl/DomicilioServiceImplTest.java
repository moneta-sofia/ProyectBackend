package com.dh.Clinica.service.impl;

import com.dh.Clinica.dto.DomicilioDTO;
import com.dh.Clinica.service.IDomicilioService;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

@SpringBootTest
class DomicilioServiceImplTest {

    @Autowired
    private IDomicilioService domicilioService;


    @Test
    public void T1_guardarDomicilio() {

        DomicilioDTO domicilioDTO = new DomicilioDTO();
        domicilioDTO.setCalle("siempre viva");
        domicilioDTO.setNumero("12345");
        domicilioDTO.setLocalidad("Santa Barbara");
        domicilioDTO.setProvincia("Jujuy");
        domicilioService.guardarDomicilio(domicilioDTO);


        DomicilioDTO domicilioBusqueda = domicilioService.buscarDomicilio(1L);
        assertTrue(domicilioBusqueda != null);
    }

    @Test
    void T2_buscarDomicilio() {
        DomicilioDTO domicilioBusqueda = domicilioService.buscarDomicilio(1L);
        assertTrue(domicilioBusqueda != null);

    }

    @Test
    void T3_buscarDomicilios() {
        DomicilioDTO domicilioDTO = new DomicilioDTO();
        domicilioDTO.setProvincia("Mendoza");
        domicilioDTO.setLocalidad("Valle grande");
        domicilioDTO.setCalle("calle");
        domicilioDTO.setNumero("72");

        domicilioService.guardarDomicilio(domicilioDTO);
        Set<DomicilioDTO> domiciliosEncontrados = domicilioService.buscarDomicilios();
        assertTrue(domiciliosEncontrados.size() > 0);
    }

    @Test
    void T4_actualizarDomicilio() {
        DomicilioDTO domicilioDTO = new DomicilioDTO();
        domicilioDTO.setId(1L);
        domicilioDTO.setCalle("siempre viva");
        domicilioDTO.setNumero("12345666");
        domicilioDTO.setLocalidad("Santa Barbara");
        domicilioDTO.setProvincia("Jujuy");
        domicilioService.actualizarDomicilio(domicilioDTO);

        DomicilioDTO domicilioDTO1 = domicilioService.buscarDomicilio(1L);
        assertEquals("12345666",domicilioDTO1.getNumero());
    }

    @Test
    void T5_liminar() {
        DomicilioDTO domicilioDTO = new DomicilioDTO();
        domicilioDTO.setProvincia("bsas");
        domicilioDTO.setLocalidad("puerto rico");
        domicilioDTO.setCalle("calle");
        domicilioDTO.setNumero("11");

        domicilioService.guardarDomicilio(domicilioDTO);

        domicilioService.eliminarDomicilio(3L);
        DomicilioDTO domicilioEliminado = domicilioService.buscarDomicilio(3L);
        assertNull(domicilioEliminado);
    }
}