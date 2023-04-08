package com.dh.Clinica.model;

import com.dh.Clinica.service.impl.TurnoServiceImpl;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Entity
@Getter
@Setter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Turno implements Serializable {
    @Id
    @SequenceGenerator(name="turno_sequence", sequenceName = "turno_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turno_sequence")
    private Long id;
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ManyToOne
    @JoinColumn(name = "pacienteId")
    private Paciente paciente;

//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ManyToOne
    @JoinColumn(name = "odontologoId")
    private Odontologo odontologo;

    private LocalDateTime fechaTurno;


}
