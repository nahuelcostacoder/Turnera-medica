package com.example.TurneraMedica.model;

import jakarta.persistence.*;
import lombok.*;

import javax.print.Doc;
import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
@Builder
public class ConsultingRoomAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consultingRoom_id")
    private ConsultingRoom consultingRoom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;


}
