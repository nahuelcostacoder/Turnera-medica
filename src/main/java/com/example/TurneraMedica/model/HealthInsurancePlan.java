package com.example.TurneraMedica.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@Entity
public class HealthInsurancePlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal coveragePercentage;

    @ManyToOne(fetch = FetchType.LAZY)
    private HealthInsurance healthInsurance;

}
