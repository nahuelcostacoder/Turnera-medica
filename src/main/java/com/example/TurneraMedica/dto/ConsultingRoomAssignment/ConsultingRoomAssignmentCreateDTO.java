package com.example.TurneraMedica.dto.ConsultingRoomAssignment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ConsultingRoomAssignmentCreateDTO {

    private LocalDate startDate;
    private LocalDate endDate;

    private Long consultingRoomId;
    private Long doctorId;
}
