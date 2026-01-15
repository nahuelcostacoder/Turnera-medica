package com.example.TurneraMedica.mapper;

import com.example.TurneraMedica.dto.HealthInsurance.PatientHealthInsuranceCreateDTO;
import com.example.TurneraMedica.dto.HealthInsurance.PatientHealthInsuranceDTO;
import com.example.TurneraMedica.model.PatientHealthInsurance;

public class MapperPatientHealthInsurance {

    public static PatientHealthInsuranceDTO toDTO(PatientHealthInsurance entity){

        if (entity == null) return null;

        return PatientHealthInsuranceDTO.builder()
                .id(entity.getId())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .patientId(entity.getPatient().getId())
                .healthInsuranceId(entity.getHealthInsurance().getId())
                .planID(entity.getPlan().getId())
                .build();
    }

    public static PatientHealthInsurance toEntity(PatientHealthInsuranceCreateDTO dto){

        if (dto == null) return null;

        return PatientHealthInsurance.builder()
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .build();

        //los objetos los cargos despues como siempre (en el service)
    }
}
