package com.example.TurneraMedica.mapper;

import com.example.TurneraMedica.dto.Patient.PatientCreateDTO;
import com.example.TurneraMedica.dto.Patient.PatientDTO;
import com.example.TurneraMedica.model.Patient;

public class MapperPatient {

    public static PatientDTO toDTO(Patient patient){

        if (patient == null) return null;

        return PatientDTO.builder()
                .id(patient.getId())
                .name(patient.getName())
                .lastName(patient.getLastName())
                .phone(patient.getPhone())
                .dni(patient.getDni())
                .email(patient.getEmail())
                .build();

        //ahi creamos el pacienteDTO agarrando los datos del usuario y paciente con herencia y el super

    }

    public static Patient toEntity(PatientCreateDTO patientCreateDTO){

        if (patientCreateDTO == null) return null;


       return Patient.builder()
               .name(patientCreateDTO.getName())
               .lastName(patientCreateDTO.getLastName())
               .phone(patientCreateDTO.getPhone())
               .dni(patientCreateDTO.getDni())
               .email(patientCreateDTO.getEmail())
               .build();

       //las credenciales no se ponen aca
    }
}
