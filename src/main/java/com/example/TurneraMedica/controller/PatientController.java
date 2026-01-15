package com.example.TurneraMedica.controller;

import com.example.TurneraMedica.dto.Patient.PatientCreateDTO;
import com.example.TurneraMedica.dto.Patient.PatientDTO;
import com.example.TurneraMedica.dto.Patient.PatientUpdateDTO;
import com.example.TurneraMedica.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private IPatientService patientService;

    @GetMapping
    public ResponseEntity<List<PatientDTO>> findAllPatients(){

        return ResponseEntity.ok(patientService.findAllPatients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> findById(@PathVariable Long id){

        return ResponseEntity.ok(patientService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PatientDTO> createPatient(@RequestBody PatientCreateDTO dto){

        PatientDTO dtoCreated = patientService.createPatient(dto);

        return ResponseEntity.created(URI.create("/api/patients/" + dtoCreated.getId())).body(dtoCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO> updatePatient(@PathVariable Long id, @RequestBody PatientUpdateDTO dto){

        return ResponseEntity.ok(patientService.updatePatient(id, dto));

        //despues devuelvo un dto normal ya que muestra todos, los modificados y los que no.
        //obviamente excepto las credenciales que solamente estan en el PatientCreateDTO
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id){

        patientService.deletePatient(id);

        return ResponseEntity.noContent().build();
    }

}
