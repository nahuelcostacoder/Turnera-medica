package com.example.TurneraMedica.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@Entity
public class PatientHealthInsurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate startDate; //alta y baja del paciente
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private HealthInsurance healthInsurance;

    @ManyToOne(fetch = FetchType.LAZY)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    private HealthInsurancePlan plan;
}
