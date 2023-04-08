package com.dh.Clinica.service.impl;

import com.dh.Clinica.dto.TurnoDTO;
import com.dh.Clinica.model.Domicilio;
import com.dh.Clinica.model.Odontologo;
import com.dh.Clinica.model.Paciente;
import com.dh.Clinica.repository.IDomicilioRepository;
import com.dh.Clinica.repository.IOdontologoRepository;
import com.dh.Clinica.repository.IPacienteRepository;
import com.dh.Clinica.service.IDomicilioService;
import com.dh.Clinica.service.IOdontologoService;
import com.dh.Clinica.service.IPacienteService;
import com.dh.Clinica.service.ITurnoService;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TurnoServiceImplTest {

    //EJECUTAR LOS TEST DE MANERA MANUAL Y EN ORDEN

    @Autowired
    private ITurnoService turnoService;



    @Test
    void T1_guardarTurno() {

        TurnoDTO turno = new TurnoDTO();
        turnoService.setPacienteExistente(1L,turno);
        turnoService.setOdontologoExistente(1L,turno);
        turno.setFechaTurno(LocalDateTime.of(2023,11,05,12,12,12));
        turnoService.guardarTurno(turno);

        TurnoDTO turnoDTO = turnoService.buscarTurno(1L);
        assertEquals(1L,turnoDTO.getId());
    }

    @Test
    void T2_buscarTurno() {
        TurnoDTO turnoDTO = turnoService.buscarTurno(1L);
        assertNotNull(turnoDTO);
    }

    @Test
    void T3_buscarTurnos() {
        TurnoDTO turno = new TurnoDTO();
        turnoService.setPacienteExistente(1L,turno);
        turnoService.setOdontologoExistente(1L,turno);
        turno.setFechaTurno(LocalDateTime.of(2023,11,05,12,12,12));
        turnoService.guardarTurno(turno);

        Set<TurnoDTO> turnos = turnoService.buscarTurnos();
        assertTrue(turnos.size() > 0);
    }

    @Test
    void T4_actualizarTurno() {
        TurnoDTO turno = new TurnoDTO();
        turno.setId(1L);

        turno.setFechaTurno(LocalDateTime.of(2023,11,05,12,12,12));
        turnoService.actualizarTurno(turno);

        TurnoDTO turnoActualizado = turnoService.buscarTurno(1L);
        assertEquals(LocalDate.of(2009,11,01),turnoActualizado.getFechaTurno());
    }

    @Test
    void T5_eliminarTurno() {
        turnoService.eliminarTurno(2L);
        TurnoDTO turno = turnoService.buscarTurno(2L);
        assertNull(turno);
    }
}