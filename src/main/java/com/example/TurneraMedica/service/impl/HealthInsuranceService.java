package com.example.TurneraMedica.service.impl;

import com.example.TurneraMedica.dto.HealthInsurance.HealthInsuranceCreateDTO;
import com.example.TurneraMedica.dto.HealthInsurance.HealthInsuranceDTO;
import com.example.TurneraMedica.dto.HealthInsurance.HealthInsuranceUpdateDTO;
import com.example.TurneraMedica.exception.NotFoundException;
import com.example.TurneraMedica.mapper.MapperHealthInsurance;
import com.example.TurneraMedica.model.HealthInsurance;
import com.example.TurneraMedica.repository.HealthInsuranceRepository;
import com.example.TurneraMedica.service.IHealthInsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthInsuranceService implements IHealthInsuranceService {

    @Autowired
    private HealthInsuranceRepository repoHI;

    @Override
    public List<HealthInsuranceDTO> findAllHealthInsurances() {
        return repoHI.findAll().stream().map(MapperHealthInsurance::toDTO).toList();
    }

    @Override
    public HealthInsuranceDTO findById(Long id){

        return MapperHealthInsurance.toDTO(repoHI.findById(id).orElseThrow(() -> new NotFoundException("THERE IS NO HEALTH INSURANCE WITH THAT ID")));
    }

    @Override
    public HealthInsuranceDTO createHealthInsurance(HealthInsuranceCreateDTO dto) {

        HealthInsurance newHI = MapperHealthInsurance.toEntity(dto);

        return MapperHealthInsurance.toDTO(repoHI.save(newHI));
    }

    @Override
    public HealthInsuranceDTO updateHealthInsurance(Long id, HealthInsuranceUpdateDTO dto) {

        HealthInsurance healthInsurance = repoHI.findById(id).orElseThrow(() -> new NotFoundException("THERE IS NO HEALTH INSURANCE WITH THAT ID TO UPDATE"));

        healthInsurance.setDescription(dto.getDescription());

        return MapperHealthInsurance.toDTO(repoHI.save(healthInsurance));
    }

    @Override
    public void deleteHealthInsurance(Long id) {

        if (!repoHI.existsById(id)) throw new NotFoundException("THERE IS NO HEALTH INSURANCE WITH THAT ID TO DELETE");

        repoHI.deleteById(id);
    }
}
