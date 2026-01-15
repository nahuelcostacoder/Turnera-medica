package com.example.TurneraMedica.service;

import com.example.TurneraMedica.dto.Appointment.AppointmentCreateDTO;
import com.example.TurneraMedica.dto.Appointment.AppointmentDTO;

import java.util.List;

public interface IAppointmentService {

    List<AppointmentDTO> findAllAppointments();
    AppointmentDTO findById(Long id);
    AppointmentDTO createAppoinment(AppointmentCreateDTO appointmentCreateDTO);
    void cancelAppointment(Long id);
}
