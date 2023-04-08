package com.dh.Clinica.service.impl;

import com.dh.Clinica.dto.OdontologoDTO;
import com.dh.Clinica.exceptions.BadRequestException;
import com.dh.Clinica.service.IOdontologoService;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class OdontologoServiceImplTest {

    //EJECUTAR LOS TEST DE MANERA MANUAL Y EN ORDEN

    @Autowired
    IOdontologoService odontologoService;

    @Test
    void T1_guardarOdontologo() throws BadRequestException {
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Otonablue");
        odontologoDTO.setApellido("Aki");
        odontologoDTO.setMatricula("matriculaxd");

        odontologoService.guardarOdontologo(odontologoDTO);
        OdontologoDTO odontologoEncontrado = odontologoService.buscarOdontologo(1L);
        assertEquals(odontologoDTO.getNombre(),odontologoEncontrado.getNombre());

    }

    @Test
    void T2_buscarOdontologo() {
        OdontologoDTO odontologoDTO = odontologoService.buscarOdontologo(1L);
        assertEquals("Aki",odontologoDTO.getApellido());
    }

    @Test
    void T3_buscarOdontologos() throws BadRequestException {
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Anya");
        odontologoDTO.setApellido("Taylor");
        odontologoDTO.setMatricula("zal225");

        odontologoService.guardarOdontologo(odontologoDTO);

        odontologoService.buscarOdontologos();
        assertNotNull(odontologoDTO);
    }

    @Test
    void T4_actualizarOdontologo() throws BadRequestException {
        OdontologoDTO odontologoDTO1 = new OdontologoDTO();
        odontologoDTO1.setNombre("Zair");
        odontologoDTO1.setApellido("Muniz");
        odontologoDTO1.setMatricula("sjadknjka123");
        odontologoService.guardarOdontologo(odontologoDTO1);

        OdontologoDTO odontologoDTO2 = new OdontologoDTO();
        odontologoDTO2.setId(3L);
        odontologoDTO2.setNombre("Zair");
        odontologoDTO2.setApellido("Muniz");
        odontologoDTO2.setMatricula("jksndajkasd32342");

        odontologoService.actualizarOdontologo(odontologoDTO2);
        OdontologoDTO odontologoEncontrado = odontologoService.buscarOdontologo(3L);
        assertEquals(odontologoDTO2.getMatricula(),odontologoEncontrado.getMatricula());

    }

    @Test
    void T5_eliminar() {
        odontologoService.eliminarOdontologo(3L);
        OdontologoDTO odontologoEncontrado = odontologoService.buscarOdontologo(3L);
        assertNull(odontologoEncontrado);
    }
}