package com.example.TurneraMedica.mapper;

import com.example.TurneraMedica.dto.Appointment.AppointmentCreateDTO;
import com.example.TurneraMedica.dto.Appointment.AppointmentDTO;
import com.example.TurneraMedica.model.Appointment;

public class MapperAppointment {

    public static AppointmentDTO toDTO (Appointment appointment){

        if (appointment == null) return null;

        return AppointmentDTO.builder()
                .id(appointment.getId())
                .basePrice(appointment.getBasePrice())
                .totalPrice(appointment.getTotalPrice())
                .date(appointment.getDate())
                .time(appointment.getTime())
                .doctorId(appointment.getId())
                .patientId(appointment.getId())
                .build();
    }

    public static Appointment toEntity (AppointmentCreateDTO dto){

        if (dto == null) return null;

        return Appointment.builder()
                .date(dto.getDate())
                .time(dto.getTime())
                .build();

        //los objetos se resuelven en el service.
    }
}
