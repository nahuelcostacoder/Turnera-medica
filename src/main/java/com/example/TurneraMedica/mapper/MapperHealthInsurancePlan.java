package com.example.TurneraMedica.mapper;

import com.example.TurneraMedica.dto.InsurancePlan.HealthInsurancePlanCreateDTO;
import com.example.TurneraMedica.dto.InsurancePlan.HealthInsurancePlanDTO;
import com.example.TurneraMedica.model.HealthInsurancePlan;

public class MapperHealthInsurancePlan {

    public static HealthInsurancePlanDTO toDTO(HealthInsurancePlan HIPlan){

        if (HIPlan == null) return null;

        return HealthInsurancePlanDTO.builder()
                .id(HIPlan.getId())
                .name(HIPlan.getName())
                .coveragePercentage(HIPlan.getCoveragePercentage())
                .healthInsuranceId(HIPlan.getHealthInsurance().getId())
                .build();
    }

    public static HealthInsurancePlan toEntity(HealthInsurancePlanCreateDTO dto){

        if (dto == null) return null;

        return HealthInsurancePlan.builder()
                .name(dto.getName())
                .coveragePercentage(dto.getCoveragePercentage())
                .build();

        //luego debemos en el service buscar la obra social
    }
}
