package com.dh.Clinica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Entity
@Table
@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Domicilio implements Serializable{
    @Id
    @SequenceGenerator(name = "idDomicilio", sequenceName = "idDomicilio", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idDomicilio")
    private Long id;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;

    @OneToOne(mappedBy = "domicilio")
    @JsonIgnore
    private Paciente paciente;


}
