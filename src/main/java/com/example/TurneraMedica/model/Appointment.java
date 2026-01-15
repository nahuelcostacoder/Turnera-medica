package com.example.TurneraMedica.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;


@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
@Builder
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal basePrice;
    private BigDecimal totalPrice;

    private LocalDate date;
    private LocalTime time;

    //doctor

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor; //muchos turnos puede tener un doctor, pero un turno puee tener un doctor solo

    //patient

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;
}
