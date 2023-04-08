package com.dh.Clinica.dto;

import com.dh.Clinica.model.Odontologo;
import com.dh.Clinica.model.Paciente;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
@Getter
@Setter
@JsonIgnoreProperties
public class TurnoDTO implements Serializable{
    private Long id;
    private LocalDate fechaTurno;

    private Paciente paciente;

    private Odontologo odontologo;
}
