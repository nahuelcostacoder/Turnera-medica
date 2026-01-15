package com.example.TurneraMedica.controller;

import com.example.TurneraMedica.dto.HealthInsurance.DoctorHealthInsuranceCreateDTO;
import com.example.TurneraMedica.dto.HealthInsurance.DoctorHealthInsuranceDTO;
import com.example.TurneraMedica.dto.HealthInsurance.DoctorHealthInsuranceUpdateDTO;
import com.example.TurneraMedica.dto.HealthInsurance.PatientHealthInsuranceDTO;
import com.example.TurneraMedica.model.DoctorHealthInsurance;
import com.example.TurneraMedica.service.IDoctorHealthInsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/doctorsInsurances")
public class DoctorHealthInsuranceController {

    @Autowired
    private IDoctorHealthInsuranceService doctorInsuranceService;

    @GetMapping
    public ResponseEntity<List<DoctorHealthInsuranceDTO>> findAllDoctorsInsurances(){

        return ResponseEntity.ok(doctorInsuranceService.findAllDoctorsInsurances());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorHealthInsuranceDTO> findById(@PathVariable Long id){

        return ResponseEntity.ok(doctorInsuranceService.findById(id));
    }

    @PostMapping
    public ResponseEntity<DoctorHealthInsuranceDTO> createDoctorInsurance(@RequestBody DoctorHealthInsuranceCreateDTO dto){


        DoctorHealthInsuranceDTO dtoCreated = doctorInsuranceService.createDoctorInsurance(dto);

        return ResponseEntity.created(URI.create("/api/doctorsInsurances/" + dtoCreated.getId())).body(dtoCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorHealthInsuranceDTO> updateDoctorInsurance(@PathVariable Long id, @RequestBody DoctorHealthInsuranceUpdateDTO dto){

        return ResponseEntity.ok(doctorInsuranceService.updateDoctorInsurance(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctorInsurance(@PathVariable Long id){

        doctorInsuranceService.deleteDoctorInsurance(id);

        return ResponseEntity.noContent().build();
    }

}
