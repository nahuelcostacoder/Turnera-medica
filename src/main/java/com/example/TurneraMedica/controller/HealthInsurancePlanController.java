package com.example.TurneraMedica.controller;

import com.example.TurneraMedica.dto.InsurancePlan.HealthInsurancePlanCreateDTO;
import com.example.TurneraMedica.dto.InsurancePlan.HealthInsurancePlanDTO;
import com.example.TurneraMedica.dto.InsurancePlan.HealthInsurancePlanUpdateDTO;
import com.example.TurneraMedica.service.IHealthInsurancePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/healthInsurancePlans")
public class HealthInsurancePlanController {

    @Autowired
    private IHealthInsurancePlanService insuranceService;

    @GetMapping
    public ResponseEntity<List<HealthInsurancePlanDTO>> findAllInsurancePlans(){

        return ResponseEntity.ok(insuranceService.findAllHIPlans());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HealthInsurancePlanDTO> findById(@PathVariable Long id){

        return ResponseEntity.ok(insuranceService.findById(id));
    }

    @PostMapping
    public ResponseEntity<HealthInsurancePlanDTO> createInsurancePlan(@RequestBody HealthInsurancePlanCreateDTO dto){

        HealthInsurancePlanDTO dtoCreated = insuranceService.createHIPlan(dto);

        return ResponseEntity.created(URI.create("/api/healthInsurancePlans/" + dtoCreated.getId())).body(dtoCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HealthInsurancePlanDTO> updateInsurancePlan(@PathVariable Long id, @RequestBody HealthInsurancePlanUpdateDTO dto){

        return ResponseEntity.ok(insuranceService.updateHIPlan(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInsurancePlan(@PathVariable Long id){

        insuranceService.deleteHIPlan(id);

        return ResponseEntity.noContent().build();
    }

}
