package com.example.TurneraMedica.mapper;

import com.example.TurneraMedica.dto.Doctor.DoctorCreateDTO;
import com.example.TurneraMedica.dto.Doctor.DoctorDTO;
import com.example.TurneraMedica.model.Doctor;

public class MapperDoctor {

    public static DoctorDTO toDTO(Doctor doctor){

        if (doctor == null) return null;

        return DoctorDTO.builder()
                .id(doctor.getId())
                .name(doctor.getName())
                .lastName(doctor.getLastName())
                .phone(doctor.getPhone())
                .dni(doctor.getDni())
                .licenceNumber(doctor.getLicenceNumber())
                .speciality(doctor.getSpeciality())
                .build();
    }


    public static Doctor toEntity(DoctorCreateDTO doctorCreateDTO){

        if (doctorCreateDTO == null) return null;

        return Doctor.builder()
                .name(doctorCreateDTO.getName())
                .lastName(doctorCreateDTO.getLastName())
                .phone(doctorCreateDTO.getPhone())
                .dni(doctorCreateDTO.getDni())
                .licenceNumber(doctorCreateDTO.getLicenceNumber())
                .speciality(doctorCreateDTO.getSpeciality())
                .build();

    }
}
