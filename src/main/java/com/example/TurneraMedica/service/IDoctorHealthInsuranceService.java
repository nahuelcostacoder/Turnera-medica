package com.example.TurneraMedica.service;

import com.example.TurneraMedica.dto.HealthInsurance.DoctorHealthInsuranceCreateDTO;
import com.example.TurneraMedica.dto.HealthInsurance.DoctorHealthInsuranceDTO;
import com.example.TurneraMedica.dto.HealthInsurance.DoctorHealthInsuranceUpdateDTO;
import com.example.TurneraMedica.model.DoctorHealthInsurance;

import javax.print.Doc;
import java.util.List;

public interface IDoctorHealthInsuranceService {

    List<DoctorHealthInsuranceDTO> findAllDoctorsInsurances();
    DoctorHealthInsuranceDTO findById(Long id);
    DoctorHealthInsuranceDTO createDoctorInsurance(DoctorHealthInsuranceCreateDTO dto);
    DoctorHealthInsuranceDTO updateDoctorInsurance(Long id, DoctorHealthInsuranceUpdateDTO dto);
    void deleteDoctorInsurance(Long id);
}
