package com.example.TurneraMedica.dto.HealthInsurance;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class HealthInsuranceDTO {

    private Long id;
    private String name;
    private String description;
}
