package com.example.TurneraMedica.mapper;


import com.example.TurneraMedica.dto.HealthInsurance.DoctorHealthInsuranceCreateDTO;
import com.example.TurneraMedica.dto.HealthInsurance.DoctorHealthInsuranceDTO;
import com.example.TurneraMedica.model.DoctorHealthInsurance;

public class MapperDoctorHealthInsurance {

    public static DoctorHealthInsuranceDTO toDTO(DoctorHealthInsurance entity){

        if (entity == null) return null;

        return DoctorHealthInsuranceDTO.builder()
                .id(entity.getId())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .healthInsuranceId(entity.getHealthInsurance().getId())
                .doctorId(entity.getDoctor().getId())
                .planId(entity.getPlan().getId())
                .build();
    }

    public static DoctorHealthInsurance toEntity (DoctorHealthInsuranceCreateDTO dto){


        if (dto == null) return null;

        return DoctorHealthInsurance.builder()
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .build();

        //los demas atributos los busco en el service
    }
}
