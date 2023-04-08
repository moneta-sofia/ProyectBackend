package com.dh.Clinica.dto;

import com.dh.Clinica.model.Domicilio;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
@Getter
@Setter
@JsonIgnoreProperties
public class PacienteDTO implements Serializable {
    private Long id;
    private String nombre;

    private String apellido;

    private String dni;

    private String email;

    private Domicilio domicilio;
}
