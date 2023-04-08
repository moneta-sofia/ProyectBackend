package com.dh.Clinica.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@JsonIgnoreProperties
public class OdontologoDTO implements Serializable{

    private Long id;
    private String nombre;

    private String apellido;

    private String matricula;
}
