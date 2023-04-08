package com.dh.Clinica.service.impl;

import com.dh.Clinica.dto.PacienteDTO;
import com.dh.Clinica.exceptions.BadRequestException;
import com.dh.Clinica.model.Domicilio;
import com.dh.Clinica.service.IPacienteService;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class PacienteServiceImplTest {

    //EJECUTAR LOS TEST DE MANERA MANUAL Y EN ORDEN

    @Autowired
    private IPacienteService pacienteService;

    @Test
    void T1_guardarPaciente() throws BadRequestException {
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("calle generica");
        domicilio.setNumero("132");
        domicilio.setLocalidad("localidad generica");
        domicilio.setProvincia("provincia generica");

        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setNombre("Juan");
        pacienteDTO.setApellido("Perez");
        pacienteDTO.setDni("123456789");
        pacienteDTO.setEmail("kenaa@example.com");
        pacienteDTO.setDomicilio(domicilio);
        pacienteService.guardarPaciente(pacienteDTO);
        PacienteDTO pacienteBusqueda = pacienteService.buscarPaciente(1L);
        assertTrue(pacienteBusqueda != null);
    }

    @Test
    void T2_buscarPaciente() {
        PacienteDTO pacienteBusqueda = pacienteService.buscarPaciente(1L);
        assertEquals("Juan", pacienteBusqueda.getNombre());
    }

    @Test
    void T3_buscarPacientes() throws BadRequestException {
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("calle generica2");
        domicilio.setNumero("132 2");
        domicilio.setLocalidad("localidad generica2");
        domicilio.setProvincia("provincia generica2");

        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setNombre("Juana");
        pacienteDTO.setApellido("Perez");
        pacienteDTO.setDni("123456789");
        pacienteDTO.setEmail("example@example.com");
        pacienteDTO.setDomicilio(domicilio);

        pacienteService.guardarPaciente(pacienteDTO);
        Set<PacienteDTO> pacienteBusqueda = pacienteService.buscarPacientes();
        assertTrue(pacienteBusqueda.size() >= 0);
    }

    @Test
    void T4_actualizarPaciente() throws BadRequestException {
        PacienteDTO pacienteDTO1 = new PacienteDTO();
        pacienteDTO1.setNombre("Maria");
        pacienteDTO1.setApellido("Castillo");
        pacienteDTO1.setDni("asdasdasdasda");
        pacienteDTO1.setEmail("asd@example.com");
        pacienteService.guardarPaciente(pacienteDTO1);

        PacienteDTO pacienteDTO2 = new PacienteDTO();
        pacienteDTO2.setId(3L);
        pacienteDTO2.setNombre("Maria");
        pacienteDTO2.setApellido("Madrid");
        pacienteDTO2.setDni("asdasdasdasda");
        pacienteDTO2.setEmail("asd@example.com");
        pacienteService.actualizarPaciente(pacienteDTO2);

        PacienteDTO pacienteEncontrado = pacienteService.buscarPaciente(3L);
        assertEquals(pacienteDTO2.getApellido(),pacienteEncontrado.getApellido());
    }

    @Test
    void T5_eliminar() {
        pacienteService.eliminarPaciente(3L);
        PacienteDTO pacienteEncontrado = pacienteService.buscarPaciente(3L);
        assertNull(pacienteEncontrado);

    }
}