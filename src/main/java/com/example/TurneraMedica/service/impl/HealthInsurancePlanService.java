package com.example.TurneraMedica.service.impl;

import com.example.TurneraMedica.dto.InsurancePlan.HealthInsurancePlanCreateDTO;
import com.example.TurneraMedica.dto.InsurancePlan.HealthInsurancePlanDTO;
import com.example.TurneraMedica.dto.InsurancePlan.HealthInsurancePlanUpdateDTO;
import com.example.TurneraMedica.exception.BusinessException;
import com.example.TurneraMedica.exception.NotFoundException;
import com.example.TurneraMedica.mapper.MapperHealthInsurancePlan;
import com.example.TurneraMedica.model.HealthInsurance;
import com.example.TurneraMedica.model.HealthInsurancePlan;
import com.example.TurneraMedica.repository.HealthInsurancePlanRepository;
import com.example.TurneraMedica.repository.HealthInsuranceRepository;
import com.example.TurneraMedica.service.IHealthInsurancePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class HealthInsurancePlanService implements IHealthInsurancePlanService {

    @Autowired
    private HealthInsurancePlanRepository repoHIPlan;

    @Autowired
    private HealthInsuranceRepository repoHI;


    @Override
    public List<HealthInsurancePlanDTO> findAllHIPlans() {
        return repoHIPlan.findAll().stream().map(MapperHealthInsurancePlan::toDTO).toList();
    }

    @Override
    public HealthInsurancePlanDTO findById(Long id){

        return MapperHealthInsurancePlan.toDTO(repoHIPlan.findById(id).orElseThrow(() -> new NotFoundException("THERE IS NO HEALTH INSURANCE PLAN WITH THAT ID")));
    }

    @Override
    public HealthInsurancePlanDTO createHIPlan(HealthInsurancePlanCreateDTO dto) {

        //primero verificamos que sea valido el porcentaje de cobertura por obra social
        verifyCoverage(dto.getCoveragePercentage());

        HealthInsurancePlan newHIPlan = MapperHealthInsurancePlan.toEntity(dto);

        //Buscamos la obra social propietaria de ese plan

        HealthInsurance healthInsurance = repoHI.findById(dto.getHealthInsuranceId()).orElseThrow(() -> new NotFoundException("THERE IS NO HEALTH INSURANCE WITH THAT ID"));

        newHIPlan.setHealthInsurance(healthInsurance);

        return MapperHealthInsurancePlan.toDTO(repoHIPlan.save(newHIPlan));
    }

    @Override
    public HealthInsurancePlanDTO updateHIPlan(Long id, HealthInsurancePlanUpdateDTO dto) {

        //verificamos nuevamente aca
        verifyCoverage(dto.getCoveragePercentage());

        HealthInsurancePlan healthInsurancePlan = repoHIPlan.findById(id).orElseThrow(() -> (new NotFoundException("THERE IS NO HEALTH INSURANCE PLAN WITH THAT ID TO UPDATE")));

        healthInsurancePlan.setCoveragePercentage(dto.getCoveragePercentage());

        return MapperHealthInsurancePlan.toDTO(repoHIPlan.save(healthInsurancePlan));
    }

    @Override
    public void deleteHIPlan(Long id) {

        if (!repoHIPlan.existsById(id)) throw new NotFoundException("THERE IS NO HEALTH INSURANCE PLAN WITH THAT ID TO DELETE");

        repoHIPlan.deleteById(id);
    }


    private void verifyCoverage(BigDecimal coverage){

        if (coverage == null) throw new BusinessException("COVERAGE PERCENTAGE CANNOT BE NULL");

        if (coverage.compareTo(BigDecimal.valueOf(100)) > 0){

            throw new BusinessException("COVERAGE PERCENTAGE CANNOT BE HIGHER THAN 100");
        }

        if (coverage.compareTo(BigDecimal.valueOf(0)) < 0){

            throw new BusinessException("COVERAGE PERCANTAGE CANNOT BE LOWER THAN 0");
        }

    }
}
