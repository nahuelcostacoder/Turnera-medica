package com.example.TurneraMedica.dto.ConsultingRoomAssignment;

import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class ConsultingRoomAssignmentDTO {

    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;

    private Long consultingRoomId;
    private Long doctorId;

}
