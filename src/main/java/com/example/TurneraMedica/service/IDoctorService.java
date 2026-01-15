package com.example.TurneraMedica.service;

import com.example.TurneraMedica.dto.Doctor.DoctorCreateDTO;
import com.example.TurneraMedica.dto.Doctor.DoctorDTO;
import com.example.TurneraMedica.dto.Doctor.DoctorUpdateDTO;

import java.util.List;

public interface IDoctorService {

    List<DoctorDTO> findAllDoctors();
    DoctorDTO findById(Long id);
    DoctorDTO createDoctor(DoctorCreateDTO doctorCreateDTO);
    DoctorDTO updateDoctor(Long id, DoctorUpdateDTO doctorUpdateDTO);
    void deleteDoctor(Long id);
}
