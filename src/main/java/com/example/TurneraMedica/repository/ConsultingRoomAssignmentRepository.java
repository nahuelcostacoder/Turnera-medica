package com.example.TurneraMedica.repository;

import com.example.TurneraMedica.model.ConsultingRoomAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultingRoomAssignmentRepository extends JpaRepository<ConsultingRoomAssignment, Long> {

    List<ConsultingRoomAssignment> findByDoctorId(Long doctorId);
    List<ConsultingRoomAssignment> findByDoctorIdAndIdNot(Long doctorId, Long id);

}
