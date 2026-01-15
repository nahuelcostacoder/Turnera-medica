package com.example.TurneraMedica.service.impl;

import com.example.TurneraMedica.dto.Doctor.DoctorCreateDTO;
import com.example.TurneraMedica.dto.Doctor.DoctorDTO;
import com.example.TurneraMedica.dto.Doctor.DoctorUpdateDTO;
import com.example.TurneraMedica.exception.NotFoundException;
import com.example.TurneraMedica.mapper.MapperDoctor;
import com.example.TurneraMedica.model.Credentials;
import com.example.TurneraMedica.model.Doctor;
import com.example.TurneraMedica.repository.DoctorRepository;
import com.example.TurneraMedica.service.ICredentialsService;
import com.example.TurneraMedica.service.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService implements IDoctorService {

    @Autowired
    private DoctorRepository repoDoctor;

    @Autowired
    private ICredentialsService serviceCredentials;

    @Override
    public List<DoctorDTO> findAllDoctors() {

        return repoDoctor.findAll().stream().map(MapperDoctor::toDTO).toList();
    }

    @Override
    public DoctorDTO findById(Long id){

        return MapperDoctor.toDTO(repoDoctor.findById(id).orElseThrow(() -> new NotFoundException("THERE IS NO DOCTOR WITH THAT ID")));
    }

    @Override
    public DoctorDTO createDoctor(DoctorCreateDTO doctorCreateDTO) {

        Doctor doctor = MapperDoctor.toEntity(doctorCreateDTO);

        //Buscamos las credenciales que vienen en este CreateDTO

        Credentials credentials = serviceCredentials.createCredentials(doctorCreateDTO.getCredentials());

        doctor.setCredentials(credentials);

        return MapperDoctor.toDTO(repoDoctor.save(doctor));
    }

    @Override
    public DoctorDTO updateDoctor(Long id, DoctorUpdateDTO doctorUpdateDTO) {

        //Busco el doctor por id

        Doctor doctor = repoDoctor.findById(id).orElseThrow(() -> new NotFoundException("THERE IS NO DOCTOR WITH THAT ID TO UPDATE"));

        doctor.setName(doctorUpdateDTO.getName());
        doctor.setLastName(doctorUpdateDTO.getLastName());
        doctor.setPhone(doctorUpdateDTO.getPhone());
        doctor.setSpeciality(doctorUpdateDTO.getSpeciality());

        return MapperDoctor.toDTO(repoDoctor.save(doctor));
    }

    @Override
    public void deleteDoctor(Long id) {

        if (!repoDoctor.existsById(id)) throw new NotFoundException("THERE IS NO DOCTOR WITH THAT ID TO DELETE");

        repoDoctor.deleteById(id);
    }
}
