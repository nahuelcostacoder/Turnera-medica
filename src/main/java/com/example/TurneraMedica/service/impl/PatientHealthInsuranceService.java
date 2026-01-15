package com.example.TurneraMedica.service.impl;

import com.example.TurneraMedica.dto.HealthInsurance.PatientHealthInsuranceCreateDTO;
import com.example.TurneraMedica.dto.HealthInsurance.PatientHealthInsuranceDTO;
import com.example.TurneraMedica.dto.HealthInsurance.PatientHealthInsuranceUpdateDTO;
import com.example.TurneraMedica.exception.BusinessException;
import com.example.TurneraMedica.exception.NotFoundException;
import com.example.TurneraMedica.mapper.MapperPatientHealthInsurance;
import com.example.TurneraMedica.model.*;
import com.example.TurneraMedica.repository.HealthInsurancePlanRepository;
import com.example.TurneraMedica.repository.HealthInsuranceRepository;
import com.example.TurneraMedica.repository.PatientHealthInsuranceRepository;
import com.example.TurneraMedica.repository.PatientRepository;
import com.example.TurneraMedica.service.IPatientHealthInsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatientHealthInsuranceService implements IPatientHealthInsuranceService {

    @Autowired
    private PatientHealthInsuranceRepository repoPatientInsurance;

    @Autowired
    private PatientRepository repoPatient;

    @Autowired
    private HealthInsuranceRepository repoInsurance;

    @Autowired
    private HealthInsurancePlanRepository repoPlan;

    @Override
    public List<PatientHealthInsuranceDTO> findAllPatientsInsurances() {

        return repoPatientInsurance.findAll().stream().map(MapperPatientHealthInsurance::toDTO).toList();
    }

    @Override
    public PatientHealthInsuranceDTO findById(Long id){

        return MapperPatientHealthInsurance.toDTO(repoPatientInsurance.findById(id).orElseThrow(() -> new NotFoundException("THERE IS NO PATIENT HEALTH INSURANCE WITH THAT ID")));
    }

    @Override
    public PatientHealthInsuranceDTO createPatientInsurance(PatientHealthInsuranceCreateDTO dto) {

        PatientHealthInsurance newEntity = MapperPatientHealthInsurance.toEntity(dto);

        //validamos si la fecha no es pasado

        verifyDate(newEntity);

        //buscamos todo

        Patient patient = repoPatient.findById(dto.getPatientId()).orElseThrow(() -> new NotFoundException("THERE IS NO PATIENT WITH THAT ID"));

        HealthInsurance insurance = repoInsurance.findById(dto.getHealthInsuranceId()).orElseThrow(() -> new NotFoundException("THERE IS NO HEALTH INSURANCE WITH THAT ID"));

        HealthInsurancePlan plan = repoPlan.findById(dto.getPlanId()).orElseThrow(() -> new NotFoundException("THERE IS NO HEALTH INSURANCE PLAN WITH THAT ID"));

        newEntity.setPatient(patient);
        newEntity.setHealthInsurance(insurance);
        newEntity.setPlan(plan);

        return MapperPatientHealthInsurance.toDTO(repoPatientInsurance.save(newEntity));
    }

    @Override
    public PatientHealthInsuranceDTO updatePatientInsurance(Long id, PatientHealthInsuranceUpdateDTO dto) {

        PatientHealthInsurance patientInsurance = repoPatientInsurance.findById(id).orElseThrow(() -> new NotFoundException("THERE IS NO PATIENT HEALTH INSURANCE WITH THAT ID TO UPDATE"));

        patientInsurance.setStartDate(dto.getStartDate());
        patientInsurance.setEndDate(dto.getEndDate());

        verifyDate(patientInsurance);


        return MapperPatientHealthInsurance.toDTO(repoPatientInsurance.save(patientInsurance));
    }

    @Override
    public void deletePatientInsurance(Long id) {

        if (!repoPatientInsurance.existsById(id)) throw new NotFoundException("THERE IS NO PATIENT HEALTH INSURANCE WITH THAT ID TO DELETE");

        repoPatientInsurance.deleteById(id);
    }


    private void verifyDate(PatientHealthInsurance patientInsurance){

        LocalDate today = LocalDate.now();

        if (patientInsurance.getStartDate().isBefore(today)){

            throw new BusinessException("START DATE CANNOT BE IN THE PAST");
        }

        if (patientInsurance.getEndDate().isBefore(today)){

            throw new BusinessException("END DATE CANNOT BE IN THE PAST");
        }

        if (patientInsurance.getStartDate().isAfter(patientInsurance.getEndDate())){

            throw new BusinessException("START DATE MUST BE BEFORE END DATE");
        }

    }

}
