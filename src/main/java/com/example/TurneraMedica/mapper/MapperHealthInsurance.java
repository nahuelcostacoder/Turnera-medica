package com.example.TurneraMedica.mapper;

import com.example.TurneraMedica.dto.HealthInsurance.HealthInsuranceCreateDTO;
import com.example.TurneraMedica.dto.HealthInsurance.HealthInsuranceDTO;
import com.example.TurneraMedica.model.HealthInsurance;

public class MapperHealthInsurance {

    public static HealthInsuranceDTO toDTO (HealthInsurance healthInsurance){

        if (healthInsurance == null) return null;

        return HealthInsuranceDTO.builder()
                .id(healthInsurance.getId())
                .name(healthInsurance.getName())
                .description(healthInsurance.getDescription())
                .build();
    }


    public static HealthInsurance toEntity (HealthInsuranceCreateDTO dto){

        return HealthInsurance.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .build();
    }
}
