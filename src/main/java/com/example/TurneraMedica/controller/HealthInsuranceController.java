package com.example.TurneraMedica.controller;

import com.example.TurneraMedica.dto.HealthInsurance.HealthInsuranceCreateDTO;
import com.example.TurneraMedica.dto.HealthInsurance.HealthInsuranceDTO;
import com.example.TurneraMedica.dto.HealthInsurance.HealthInsuranceUpdateDTO;
import com.example.TurneraMedica.service.IHealthInsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/healthInsurances")
public class HealthInsuranceController {

    @Autowired
    private IHealthInsuranceService HIService;

    @GetMapping
    public ResponseEntity<List<HealthInsuranceDTO>> findAllHealthInsurances(){

        return ResponseEntity.ok(HIService.findAllHealthInsurances());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HealthInsuranceDTO> findById(@PathVariable Long id){

        return ResponseEntity.ok(HIService.findById(id));
    }

    @PostMapping
    public ResponseEntity<HealthInsuranceDTO> createHealthInsurance(@RequestBody HealthInsuranceCreateDTO dto){

        HealthInsuranceDTO dtoCreated = HIService.createHealthInsurance(dto);

        return ResponseEntity.created(URI.create("/api/healthInsurances/" + dtoCreated.getId())).body(dtoCreated);
    }


    @PutMapping("/{id}")
    public ResponseEntity<HealthInsuranceDTO> updateHealthInsurance(@PathVariable Long id, @RequestBody HealthInsuranceUpdateDTO dto){

        return ResponseEntity.ok(HIService.updateHealthInsurance(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHealthInsurance(@PathVariable Long id){

        HIService.deleteHealthInsurance(id);

        return ResponseEntity.noContent().build();
    }



}
