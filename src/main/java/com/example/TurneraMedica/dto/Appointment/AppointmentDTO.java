package com.example.TurneraMedica.dto.Appointment;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class AppointmentDTO {

    private Long id;
    private BigDecimal basePrice;
    private BigDecimal totalPrice;

    private LocalDate date;
    private LocalTime time;

    //doctor
    private Long doctorId;

    private Long patientId;
}
