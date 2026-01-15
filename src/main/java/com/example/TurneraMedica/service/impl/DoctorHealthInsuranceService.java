package com.example.TurneraMedica.service.impl;

import com.example.TurneraMedica.dto.HealthInsurance.DoctorHealthInsuranceCreateDTO;
import com.example.TurneraMedica.dto.HealthInsurance.DoctorHealthInsuranceDTO;
import com.example.TurneraMedica.dto.HealthInsurance.DoctorHealthInsuranceUpdateDTO;
import com.example.TurneraMedica.exception.BusinessException;
import com.example.TurneraMedica.exception.NotFoundException;
import com.example.TurneraMedica.mapper.MapperDoctorHealthInsurance;
import com.example.TurneraMedica.model.*;
import com.example.TurneraMedica.repository.DoctorHealthInsuranceRepository;
import com.example.TurneraMedica.repository.DoctorRepository;
import com.example.TurneraMedica.repository.HealthInsurancePlanRepository;
import com.example.TurneraMedica.repository.HealthInsuranceRepository;
import com.example.TurneraMedica.service.IDoctorHealthInsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DoctorHealthInsuranceService implements IDoctorHealthInsuranceService {

    @Autowired
    private DoctorHealthInsuranceRepository repoDoctorInsurance;

    @Autowired
    private HealthInsuranceRepository repoInsurance;

    @Autowired
    private DoctorRepository repoDoctor;

    @Autowired
    private HealthInsurancePlanRepository repoPlan;

    @Override
    public List<DoctorHealthInsuranceDTO> findAllDoctorsInsurances() {

        return repoDoctorInsurance.findAll().stream().map(MapperDoctorHealthInsurance::toDTO).toList();
    }

    @Override
    public DoctorHealthInsuranceDTO findById(Long id){

        return MapperDoctorHealthInsurance.toDTO(repoDoctorInsurance.findById(id).orElseThrow(() -> new NotFoundException("THERE IS NO DOCTOR HEALTH INURANCE WITH THAT ID")));
    }

    @Override
    public DoctorHealthInsuranceDTO createDoctorInsurance(DoctorHealthInsuranceCreateDTO dto) {

        DoctorHealthInsurance newEntity = MapperDoctorHealthInsurance.toEntity(dto);

        //validamos fechas

        verifyDate(newEntity);

        HealthInsurance healthInsurance = repoInsurance.findById(dto.getHealthInsuranceId()).orElseThrow(() -> new NotFoundException("THERE IS NO HEALTH INSURANCE WITH THAT ID"));

        Doctor doctor = repoDoctor.findById(dto.getDoctorId()).orElseThrow(() -> new NotFoundException("THERE IS NO DOCTOR WITH THAT ID"));

        HealthInsurancePlan plan = repoPlan.findById(dto.getPlanId()).orElseThrow(() -> new NotFoundException("THERE IS HEALTH INSURANCE PLAN WITH THAT ID"));

        newEntity.setHealthInsurance(healthInsurance);
        newEntity.setDoctor(doctor);
        newEntity.setPlan(plan);

        return MapperDoctorHealthInsurance.toDTO(repoDoctorInsurance.save(newEntity));
    }

    @Override
    public DoctorHealthInsuranceDTO updateDoctorInsurance(Long id, DoctorHealthInsuranceUpdateDTO dto) {

        DoctorHealthInsurance doctorInsurance = repoDoctorInsurance.findById(id).orElseThrow(() -> new NotFoundException("THERE IS NO DOCTOR HEALTH INSURANCE WITH THAT ID TO UPDATE"));

        doctorInsurance.setStartDate(dto.getStartDate());
        doctorInsurance.setEndDate(dto.getEndDate());

        verifyDate(doctorInsurance);

        return MapperDoctorHealthInsurance.toDTO(repoDoctorInsurance.save(doctorInsurance));
    }

    @Override
    public void deleteDoctorInsurance(Long id) {

        if (!repoDoctorInsurance.existsById(id)) throw new NotFoundException("THERE IS NO DOCTOR HEALTH INSURANCE WITH THAT ID TO DELETE");


        repoDoctorInsurance.deleteById(id);

    }

    private void verifyDate(DoctorHealthInsurance doctorInsurance) {

        LocalDate today = LocalDate.now();

        if (doctorInsurance.getStartDate().isBefore(today)) {

            throw new BusinessException("START DATE CANNOT BE IN THE PAST");
        }

        if (doctorInsurance.getEndDate().isBefore(today)) {

            throw new BusinessException("END DATE CANNOT BE IN THE PAST");
        }

        if (doctorInsurance.getStartDate().isAfter(doctorInsurance.getEndDate())) {

            throw new BusinessException("START DATE MUST BE BEFORE END DATE");
        }

    }
}