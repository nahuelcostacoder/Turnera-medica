package com.example.TurneraMedica.mapper;

import com.example.TurneraMedica.dto.ConsultingRoomAssignment.ConsultingRoomAssignmentCreateDTO;
import com.example.TurneraMedica.dto.ConsultingRoomAssignment.ConsultingRoomAssignmentDTO;
import com.example.TurneraMedica.model.ConsultingRoomAssignment;

public class MapperConsultingRoomAssignment {

    public static ConsultingRoomAssignmentDTO toDTO(ConsultingRoomAssignment crAssig){

        if (crAssig == null) return null;

        return ConsultingRoomAssignmentDTO.builder()
                .id(crAssig.getId())
                .startDate(crAssig.getStartDate())
                .endDate(crAssig.getEndDate())
                .doctorId(crAssig.getDoctor().getId())
                .consultingRoomId(crAssig.getConsultingRoom().getId())
                .build();
    }

    public static ConsultingRoomAssignment toEntity(ConsultingRoomAssignmentCreateDTO dto){

        if (dto == null) return null;

        return ConsultingRoomAssignment.builder()
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .build();
    }
}
