package com.example.TurneraMedica.controller;

import com.example.TurneraMedica.dto.Appointment.AppointmentCreateDTO;
import com.example.TurneraMedica.dto.Appointment.AppointmentDTO;
import com.example.TurneraMedica.service.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private IAppointmentService appointmentService;

    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> findAllAppointments(){

        return ResponseEntity.ok(appointmentService.findAllAppointments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> findById(@PathVariable Long id){

        return ResponseEntity.ok(appointmentService.findById(id));
    }

    @PostMapping
    public ResponseEntity<AppointmentDTO> createAppointment(@RequestBody AppointmentCreateDTO dto){

        AppointmentDTO dtoCreated = appointmentService.createAppoinment(dto);

        return ResponseEntity.created(URI.create("/api/appointments/" + dtoCreated.getId())).body(dtoCreated);
    }

    @DeleteMapping("/{id}/cancel")
    public ResponseEntity<Void> cancelAppointment(@PathVariable Long id){

        appointmentService.cancelAppointment(id);

        return ResponseEntity.noContent().build();
    }


}
