package com.example.TurneraMedica.repository;

import com.example.TurneraMedica.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
