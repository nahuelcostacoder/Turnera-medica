package com.example.TurneraMedica.controller;

import com.example.TurneraMedica.dto.HealthInsurance.PatientHealthInsuranceCreateDTO;
import com.example.TurneraMedica.dto.HealthInsurance.PatientHealthInsuranceDTO;
import com.example.TurneraMedica.dto.HealthInsurance.PatientHealthInsuranceUpdateDTO;
import com.example.TurneraMedica.service.IPatientHealthInsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/patientsInsurances")
public class PatientHealthInsuranceController {

    @Autowired
    private IPatientHealthInsuranceService patientInsuranceService;

    @GetMapping
    public ResponseEntity<List<PatientHealthInsuranceDTO>> findAllPatientsInsurances(){

        return ResponseEntity.ok(patientInsuranceService.findAllPatientsInsurances());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientHealthInsuranceDTO> findById(@PathVariable Long id){

        return ResponseEntity.ok(patientInsuranceService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PatientHealthInsuranceDTO> createPatientInsurance(@RequestBody PatientHealthInsuranceCreateDTO dto){

        PatientHealthInsuranceDTO dtoCreated = patientInsuranceService.createPatientInsurance(dto);

        return ResponseEntity.created(URI.create("/api/patientsInsurances/" + dtoCreated.getId())).body(dtoCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientHealthInsuranceDTO> updatePatientInsurance(@PathVariable Long id, @RequestBody PatientHealthInsuranceUpdateDTO dto){

        return ResponseEntity.ok(patientInsuranceService.updatePatientInsurance(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatientInsurance(@PathVariable Long id){

        patientInsuranceService.deletePatientInsurance(id);

        return ResponseEntity.noContent().build();
    }


}
