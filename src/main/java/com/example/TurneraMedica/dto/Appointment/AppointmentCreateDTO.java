package com.example.TurneraMedica.dto.Appointment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class AppointmentCreateDTO {

    private LocalDate date;
    private LocalTime time;

    private Long doctorId;
    private Long patientId;
}
