package com.example.TurneraMedica.controller;

import com.example.TurneraMedica.dto.Doctor.DoctorCreateDTO;
import com.example.TurneraMedica.dto.Doctor.DoctorDTO;
import com.example.TurneraMedica.dto.Doctor.DoctorUpdateDTO;
import com.example.TurneraMedica.service.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private IDoctorService doctorService;

    @GetMapping
    public ResponseEntity<List<DoctorDTO>> findAllDoctors(){

        return ResponseEntity.ok(doctorService.findAllDoctors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDTO> findById(@PathVariable Long id){

        return ResponseEntity.ok(doctorService.findById(id));
    }

    @PostMapping
    public ResponseEntity<DoctorDTO> createDoctor(@RequestBody DoctorCreateDTO dto){

        DoctorDTO dtoCreated = doctorService.createDoctor(dto);

        return ResponseEntity.created(URI.create("/api/doctors/" + dtoCreated.getId())).body(dtoCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorDTO> updateDoctor(@PathVariable Long id, @RequestBody DoctorUpdateDTO dto){

        return ResponseEntity.ok(doctorService.updateDoctor(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id){

        doctorService.deleteDoctor(id);

        return ResponseEntity.noContent().build();
    }
}
