package com.example.TurneraMedica.controller;

import com.example.TurneraMedica.dto.ConsultingRoom.ConsultingRoomDTO;
import com.example.TurneraMedica.service.IConsultingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/consultingRooms")
public class ConsultingRoomController {

    @Autowired
    private IConsultingRoomService consultingRoomService;

    @GetMapping
    public ResponseEntity<List<ConsultingRoomDTO>> findAllConsultingRooms(){

        return ResponseEntity.ok(consultingRoomService.findAllConsultingRooms());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultingRoomDTO> findById(@PathVariable Long id){

        return ResponseEntity.ok(consultingRoomService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ConsultingRoomDTO> createConsultingRoom(@RequestBody ConsultingRoomDTO dto){

        ConsultingRoomDTO dtoCreated = consultingRoomService.createConsultingRoom(dto);

        return ResponseEntity.created(URI.create("/api/consultingRooms/" + dtoCreated.getId())).body(dtoCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultingRoomDTO> updateConsultingRoom(@PathVariable Long id, @RequestBody ConsultingRoomDTO dto){

        return ResponseEntity.ok(consultingRoomService.updateConsultingRoom(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsultingRoom(@PathVariable Long id){

        consultingRoomService.deleteConsultingRoom(id);
        return ResponseEntity.noContent().build();
    }
}
