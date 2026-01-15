package com.example.TurneraMedica.service;

import com.example.TurneraMedica.dto.HealthInsurance.HealthInsuranceCreateDTO;
import com.example.TurneraMedica.dto.HealthInsurance.HealthInsuranceDTO;
import com.example.TurneraMedica.dto.HealthInsurance.HealthInsuranceUpdateDTO;

import java.util.List;

public interface IHealthInsuranceService {

    List<HealthInsuranceDTO> findAllHealthInsurances();
    HealthInsuranceDTO findById(Long id);
    HealthInsuranceDTO createHealthInsurance(HealthInsuranceCreateDTO dto);
    HealthInsuranceDTO updateHealthInsurance(Long id, HealthInsuranceUpdateDTO dto);
    void deleteHealthInsurance(Long id);
}
