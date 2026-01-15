package com.example.TurneraMedica.dto.ConsultingRoom;

import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class ConsultingRoomDTO {

    private Long id;
    private String name;
    private String address;
    private String serviceHours;
}
