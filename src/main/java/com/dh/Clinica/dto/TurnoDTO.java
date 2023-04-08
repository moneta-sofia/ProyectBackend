package com.dh.Clinica.dto;

import com.dh.Clinica.model.Odontologo;
import com.dh.Clinica.model.Paciente;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Getter
@Setter
@JsonIgnoreProperties
public class TurnoDTO implements Serializable{
    private Long id;
    private LocalDateTime fechaTurno;

    private Paciente paciente;

    private Odontologo odontologo;
}
