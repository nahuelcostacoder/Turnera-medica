package com.example.TurneraMedica.repository;

import com.example.TurneraMedica.model.Appointment;
import com.example.TurneraMedica.model.ConsultingRoomAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {


}
