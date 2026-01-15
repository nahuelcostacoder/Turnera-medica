package com.example.TurneraMedica.dto.InsurancePlan;

import lombok.*;

import java.math.BigDecimal;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class HealthInsurancePlanDTO {

    private Long id;
    private String name;
    private BigDecimal coveragePercentage;
    private Long healthInsuranceId;
}
