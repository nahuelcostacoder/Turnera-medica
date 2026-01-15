package com.example.TurneraMedica.dto.HealthInsurance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class DoctorHealthInsuranceCreateDTO {

    private LocalDate startDate;
    private LocalDate endDate;

    private Long healthInsuranceId;

    private Long doctorId;
    private Long planId;
}
