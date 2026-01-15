package com.example.TurneraMedica.service.impl;

import com.example.TurneraMedica.dto.ConsultingRoomAssignment.ConsultingRoomAssignmentCreateDTO;
import com.example.TurneraMedica.dto.ConsultingRoomAssignment.ConsultingRoomAssignmentDTO;
import com.example.TurneraMedica.dto.ConsultingRoomAssignment.ConsultingRoomAssignmentUpdateDTO;
import com.example.TurneraMedica.exception.BusinessException;
import com.example.TurneraMedica.exception.NotFoundException;
import com.example.TurneraMedica.mapper.MapperConsultingRoomAssignment;
import com.example.TurneraMedica.model.ConsultingRoom;
import com.example.TurneraMedica.model.ConsultingRoomAssignment;
import com.example.TurneraMedica.model.Doctor;
import com.example.TurneraMedica.repository.ConsultingRoomAssignmentRepository;
import com.example.TurneraMedica.repository.ConsultingRoomRepository;
import com.example.TurneraMedica.repository.DoctorRepository;
import com.example.TurneraMedica.service.IConsultingRoomAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ConsultingRoomAssignmentService implements IConsultingRoomAssignmentService {

    @Autowired
    private ConsultingRoomAssignmentRepository repoCrAssig;

    @Autowired
    private DoctorRepository repoDoctor;

    @Autowired
    private ConsultingRoomRepository repoCr;

    @Override
    public List<ConsultingRoomAssignmentDTO> findAllRoomsAssignments() {

        return repoCrAssig.findAll().stream().map(MapperConsultingRoomAssignment::toDTO).toList();
    }

    @Override
    public ConsultingRoomAssignmentDTO findById(Long id){

        return MapperConsultingRoomAssignment.toDTO(repoCrAssig.findById(id).orElseThrow(() -> new NotFoundException("THERE IS NO CONSULTING ROOM ASSIGNMENT WITH THAT ID")));
    }

    @Override
    public ConsultingRoomAssignmentDTO createRoomAssignment(ConsultingRoomAssignmentCreateDTO dto) {

        ConsultingRoomAssignment newCrAssig = MapperConsultingRoomAssignment.toEntity(dto);

        //verificamos
        verifyDate(newCrAssig);

        Doctor doctor = repoDoctor.findById(dto.getDoctorId())
                .orElseThrow(() -> new NotFoundException("THERE IS NO DOCTOR WITH THAT ID"));

        ConsultingRoom consultingRoom = repoCr.findById(dto.getConsultingRoomId())
                .orElseThrow(() -> new NotFoundException("THERE IS NO CONSULTING ROOM WITH THAT ID"));


        //verificamos que ya no haya una fecha en ese rango
        verifyDoctorAvailabilityCreate(doctor, dto.getStartDate(), dto.getEndDate());

        newCrAssig.setDoctor(doctor);
        newCrAssig.setConsultingRoom(consultingRoom);

        return MapperConsultingRoomAssignment.toDTO(repoCrAssig.save(newCrAssig));
    }

    @Override
    public ConsultingRoomAssignmentDTO updateRoomAssignment(Long id, ConsultingRoomAssignmentUpdateDTO dto) {

        ConsultingRoomAssignment cr = repoCrAssig.findById(id).orElseThrow(() -> new NotFoundException("THERE IS NO ROOM ASSIGNMENT WITH THAT ID"));

        cr.setStartDate(dto.getStartDate());
        cr.setEndDate(dto.getEndDate());

        //verificamos
        verifyDate(cr);

        verifyDoctorAvailabilityUpdate(cr);


        return MapperConsultingRoomAssignment.toDTO(repoCrAssig.save(cr));
    }

    @Override
    public void deleteRoomAssignment(Long id) {

        if (!repoCrAssig.existsById(id)) throw new NotFoundException("THERE IS NO CONSULTING ROOM ASSIGNMENT WITH THAT ID");

        repoCrAssig.deleteById(id);
    }


    private void verifyDate(ConsultingRoomAssignment cr){

        //DEBO VERIFICAR

        //1) QUE SEAN TANTO EL START DATE COMO EL END DATE POSTERIORES AL PRESENTE

        LocalDate today = LocalDate.now();

        if (cr.getStartDate().isBefore(today)){

            throw new BusinessException("START DATE CANNOT BE IN THE PAST");
        }

        if (cr.getEndDate().isBefore(today)){

            throw new BusinessException("END DATE CANNOT BE IN THE PAST");
        }

        //2) QUE EL END DATE SEA POSTERIOR AL START DATE

        if (cr.getStartDate().isAfter(cr.getEndDate())){

            throw new BusinessException("START DATE MUST BE BEFORE END DATE");
        }

    }

    private void verifyDoctorAvailabilityCreate(Doctor doctor, LocalDate newStart, LocalDate newEnd){

        List<ConsultingRoomAssignment> crAssigDoc = repoCrAssig.findByDoctorId(doctor.getId());

        boolean found = crAssigDoc.stream().
                anyMatch(consultingRoomAssignment -> !newEnd.isBefore(consultingRoomAssignment.getStartDate()) && !newStart.isAfter(consultingRoomAssignment.getEndDate()));

        if (found) throw new BusinessException("DOCTOR IS ALREADY ASSIGNED TO ANOTHER CONSULTING ROOM IN THIS DATE RANGE");
    }

    private void verifyDoctorAvailabilityUpdate(ConsultingRoomAssignment currentCr){

        List<ConsultingRoomAssignment> crAssigDoc = repoCrAssig.findByDoctorIdAndIdNot(currentCr.getDoctor().getId(), currentCr.getId());

        boolean found = crAssigDoc.stream()
                .anyMatch(consultingRoomAssignment -> !currentCr.getEndDate().isBefore(consultingRoomAssignment.getStartDate()) && !currentCr.getStartDate().isAfter(consultingRoomAssignment.getEndDate()));

        if (found) throw new BusinessException("DOCTOR IS ALREADY ASSIGNED TO ANOTHER CONSULTING ROOM IN THIS DATE RANGE");
    }
}
