package com.dh.Clinica.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@JsonIgnoreProperties
public class DomicilioDTO implements Serializable{
    private Long id;

    private String calle;

    private String numero;

    private String localidad;
    private String provincia;
}
