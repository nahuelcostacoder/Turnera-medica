package com.example.TurneraMedica.service;

import com.example.TurneraMedica.dto.HealthInsurance.PatientHealthInsuranceCreateDTO;
import com.example.TurneraMedica.dto.HealthInsurance.PatientHealthInsuranceDTO;
import com.example.TurneraMedica.dto.HealthInsurance.PatientHealthInsuranceUpdateDTO;

import java.util.List;

public interface IPatientHealthInsuranceService {

    List<PatientHealthInsuranceDTO> findAllPatientsInsurances();
    PatientHealthInsuranceDTO findById(Long id);
    PatientHealthInsuranceDTO createPatientInsurance(PatientHealthInsuranceCreateDTO dto);
    PatientHealthInsuranceDTO updatePatientInsurance(Long id, PatientHealthInsuranceUpdateDTO dto);
    void deletePatientInsurance(Long id);
}
