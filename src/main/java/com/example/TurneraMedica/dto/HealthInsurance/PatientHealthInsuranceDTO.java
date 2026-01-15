package com.example.TurneraMedica.dto.HealthInsurance;

import com.example.TurneraMedica.model.HealthInsurance;
import com.example.TurneraMedica.model.HealthInsurancePlan;
import com.example.TurneraMedica.model.Patient;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class PatientHealthInsuranceDTO {

    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;

    private Long healthInsuranceId;

    private Long patientId;
    private Long planID;
}
