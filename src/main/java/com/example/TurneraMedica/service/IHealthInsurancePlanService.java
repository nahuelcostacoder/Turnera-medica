package com.example.TurneraMedica.service;

import com.example.TurneraMedica.dto.InsurancePlan.HealthInsurancePlanCreateDTO;
import com.example.TurneraMedica.dto.InsurancePlan.HealthInsurancePlanDTO;
import com.example.TurneraMedica.dto.InsurancePlan.HealthInsurancePlanUpdateDTO;

import java.util.List;

public interface IHealthInsurancePlanService {

    List<HealthInsurancePlanDTO> findAllHIPlans();
    HealthInsurancePlanDTO findById(Long id);
    HealthInsurancePlanDTO createHIPlan(HealthInsurancePlanCreateDTO dto);
    HealthInsurancePlanDTO updateHIPlan(Long id, HealthInsurancePlanUpdateDTO dto);
    void deleteHIPlan(Long id);
}
