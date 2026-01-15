package com.example.TurneraMedica.repository;

import com.example.TurneraMedica.model.Appointment;
import com.example.TurneraMedica.model.Patient;
import com.example.TurneraMedica.model.PatientHealthInsurance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientHealthInsuranceRepository extends JpaRepository<PatientHealthInsurance, Long> {

    List<PatientHealthInsurance> findByPatientId(Long patientId);


}
