package com.example.TurneraMedica.service;

import com.example.TurneraMedica.dto.ConsultingRoomAssignment.ConsultingRoomAssignmentCreateDTO;
import com.example.TurneraMedica.dto.ConsultingRoomAssignment.ConsultingRoomAssignmentDTO;
import com.example.TurneraMedica.dto.ConsultingRoomAssignment.ConsultingRoomAssignmentUpdateDTO;

import java.util.List;

public interface IConsultingRoomAssignmentService {

    List<ConsultingRoomAssignmentDTO> findAllRoomsAssignments();
    ConsultingRoomAssignmentDTO findById(Long id);
    ConsultingRoomAssignmentDTO createRoomAssignment(ConsultingRoomAssignmentCreateDTO dto);
    ConsultingRoomAssignmentDTO updateRoomAssignment(Long id, ConsultingRoomAssignmentUpdateDTO dto);
    void deleteRoomAssignment(Long id);
}
