package com.example.TurneraMedica.controller;

import com.example.TurneraMedica.dto.ConsultingRoomAssignment.ConsultingRoomAssignmentCreateDTO;
import com.example.TurneraMedica.dto.ConsultingRoomAssignment.ConsultingRoomAssignmentDTO;
import com.example.TurneraMedica.dto.ConsultingRoomAssignment.ConsultingRoomAssignmentUpdateDTO;
import com.example.TurneraMedica.service.IConsultingRoomAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/consultingRoomAssignments")
public class ConsultingRoomAssignmentController {

    @Autowired
    private IConsultingRoomAssignmentService crAssigService;

    @GetMapping
    public ResponseEntity<List<ConsultingRoomAssignmentDTO>> findAllRoomAssignments(){

        return ResponseEntity.ok(crAssigService.findAllRoomsAssignments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultingRoomAssignmentDTO> findById(@PathVariable Long id){

        return ResponseEntity.ok(crAssigService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ConsultingRoomAssignmentDTO> createRoomAssignment(@RequestBody ConsultingRoomAssignmentCreateDTO dto){

        ConsultingRoomAssignmentDTO dtoCreated = crAssigService.createRoomAssignment(dto);

        return ResponseEntity.created(URI.create("/api/consultingRoomAssignments/" + dtoCreated.getId())).body(dtoCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultingRoomAssignmentDTO> updateRoomAssignment(@PathVariable Long id, @RequestBody ConsultingRoomAssignmentUpdateDTO dto){

        return ResponseEntity.ok(crAssigService.updateRoomAssignment(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoomAssignment(@PathVariable Long id){

        crAssigService.deleteRoomAssignment(id);

        return ResponseEntity.noContent().build();
    }
}
