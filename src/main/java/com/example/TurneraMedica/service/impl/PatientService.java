package com.example.TurneraMedica.service.impl;

import com.example.TurneraMedica.dto.Patient.PatientCreateDTO;
import com.example.TurneraMedica.dto.Patient.PatientDTO;
import com.example.TurneraMedica.dto.Patient.PatientUpdateDTO;
import com.example.TurneraMedica.exception.NotFoundException;
import com.example.TurneraMedica.mapper.MapperPatient;
import com.example.TurneraMedica.model.Credentials;
import com.example.TurneraMedica.model.Patient;
import com.example.TurneraMedica.repository.PatientRepository;
import com.example.TurneraMedica.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService implements IPatientService {

    @Autowired
    private PatientRepository repoPatient;

    @Autowired
    private CredentialsService credentialsService;

    @Override
    public List<PatientDTO> findAllPatients() {

        return repoPatient.findAll().stream().map(MapperPatient::toDTO).toList();
    }

    @Override
    public PatientDTO findById(Long id){

        return MapperPatient.toDTO(repoPatient.findById(id).orElseThrow(() -> new NotFoundException("THERE IS NO PATIENT WITH THAT ID")));
    }

    @Override
    public PatientDTO createPatient(PatientCreateDTO patientCreateDTO) {

        Patient patient = MapperPatient.toEntity(patientCreateDTO);

        //obtengo el paciente sin las credenciales

        //las busco

        Credentials credentials = credentialsService.createCredentials(patientCreateDTO.getCredentials());

        patient.setCredentials(credentials);


        return MapperPatient.toDTO(repoPatient.save(patient));
    }

    @Override
    public PatientDTO updatePatient(Long id, PatientUpdateDTO patientUpdateDTO) {

        Patient patient = repoPatient.findById(id)
                .orElseThrow(() -> new NotFoundException("THERE IS NO PATIENT WITH THAT ID TO UPDATE"));

        patient.setName(patientUpdateDTO.getName());
        patient.setLastName(patientUpdateDTO.getLastName());
        patient.setEmail(patientUpdateDTO.getEmail());
        patient.setPhone(patientUpdateDTO.getPhone());

        return MapperPatient.toDTO(repoPatient.save(patient));
    }

    @Override
    public void deletePatient(Long id) {

        if (!repoPatient.existsById(id)){

            throw new NotFoundException("THERE IS NO PATIENT WITH THAT ID TO DELETE");
        }

        repoPatient.deleteById(id);

    }
}
