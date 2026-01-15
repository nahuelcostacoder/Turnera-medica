package com.example.TurneraMedica.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@Entity
public class DoctorHealthInsurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private HealthInsurance healthInsurance;

    @ManyToOne(fetch = FetchType.LAZY)
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    private HealthInsurancePlan plan;
}
