package com.example.TurneraMedica.repository;

import com.example.TurneraMedica.dto.HealthInsurance.DoctorHealthInsuranceDTO;
import com.example.TurneraMedica.model.Appointment;
import com.example.TurneraMedica.model.DoctorHealthInsurance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorHealthInsuranceRepository extends JpaRepository<DoctorHealthInsurance, Long> {

    List<DoctorHealthInsurance> findByDoctorId(Long doctorId);
}