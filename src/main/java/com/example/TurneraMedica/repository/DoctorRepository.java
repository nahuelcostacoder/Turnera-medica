package com.example.TurneraMedica.repository;

import com.example.TurneraMedica.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
