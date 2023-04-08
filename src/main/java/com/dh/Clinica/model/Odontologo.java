package com.dh.Clinica.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
//import lombok.Getter;
//import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Odontologo implements Serializable{

    @Id
    @SequenceGenerator(name = "idOdontologo", sequenceName ="idOdontologo", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idOdontologo")

    private Long id;
    private String nombre;
    private String apellido;

    private String matricula;
    @OneToMany(mappedBy = "odontologo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Turno> turnos;

}
