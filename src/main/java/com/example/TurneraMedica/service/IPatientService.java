package com.example.TurneraMedica.service;

import com.example.TurneraMedica.dto.Patient.PatientCreateDTO;
import com.example.TurneraMedica.dto.Patient.PatientDTO;
import com.example.TurneraMedica.dto.Patient.PatientUpdateDTO;

import java.util.List;

public interface IPatientService {

    List<PatientDTO> findAllPatients();
    PatientDTO findById(Long id);
    PatientDTO createPatient(PatientCreateDTO patientCreateDTO);
    PatientDTO updatePatient(Long id, PatientUpdateDTO patientUpdateDTO);
    void deletePatient(Long id);
}
