package com.example.TurneraMedica.service.impl;

import com.example.TurneraMedica.dto.ConsultingRoom.ConsultingRoomDTO;
import com.example.TurneraMedica.exception.NotFoundException;
import com.example.TurneraMedica.mapper.MapperConsultingRoom;
import com.example.TurneraMedica.model.ConsultingRoom;
import com.example.TurneraMedica.repository.ConsultingRoomRepository;
import com.example.TurneraMedica.service.IConsultingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ConsultingRoomService implements IConsultingRoomService {

    //RECORDEMOS QUE NUESTRO REPOSITORY ES QUIEN TRABAJA CON LA BASE DE DATOS

    @Autowired
    private ConsultingRoomRepository repoCr;

    @Override
    public List<ConsultingRoomDTO> findAllConsultingRooms() {


        return repoCr.findAll().stream().map(MapperConsultingRoom::toDto).toList();
    }

    @Override
    public ConsultingRoomDTO findById(Long id){

        return MapperConsultingRoom.toDto(repoCr.findById(id).orElseThrow(() -> new NotFoundException("THERE IS NO CONSULTING ROOM WITH THAT ID")));
    }

    @Override
    public ConsultingRoomDTO createConsultingRoom(ConsultingRoomDTO dto) {

        /*ConsultingRoom newCr = ConsultingRoom.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .serviceHours(dto.getServiceHours())
                .build();/*

         */

        //AHORA CREO UN toEntity

        ConsultingRoom newCr = MapperConsultingRoom.toEntity(dto);

        return MapperConsultingRoom.toDto(repoCr.save(newCr));

    }

    @Override
    public ConsultingRoomDTO updateConsultingRoom(Long id, ConsultingRoomDTO dto) {

        ConsultingRoom consultingRoom = repoCr.findById(id)
                .orElseThrow(() -> new NotFoundException("THERE IS NO CONSULTING ROOM WITH THAT ID"));

        consultingRoom.setName(dto.getName());
        consultingRoom.setAddress(dto.getAddress());
        consultingRoom.setServiceHours(dto.getServiceHours());

        //RETORNO EL DTO MODIFICADO

        return MapperConsultingRoom.toDto(repoCr.save(consultingRoom));

        //guardo la entidad y retorneo el dto en base a esa entidad
    }

    @Override
    public void deleteConsultingRoom(Long id) {

        if (!repoCr.existsById(id)){

            throw new NotFoundException("THERE IS NO CONSULTING ROOM WITH THAT ID TO DELETE");
        }

        repoCr.deleteById(id);

    }
}
