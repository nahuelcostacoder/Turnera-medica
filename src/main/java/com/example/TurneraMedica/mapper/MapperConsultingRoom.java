package com.example.TurneraMedica.mapper;

import com.example.TurneraMedica.dto.ConsultingRoom.ConsultingRoomDTO;
import com.example.TurneraMedica.model.ConsultingRoom;

public class MapperConsultingRoom {

    public static ConsultingRoomDTO toDto (ConsultingRoom cr){

        //Primero verificamos que el objeto parametro NO sea null

        if (cr == null) return null;

        //AGARRO EL OBJETO TIPO ENTIDAD QUE VIENE DE LA BASE DE DATOS (CON EL REPOSITORY)
        //Y LO MAPEO A DTO QUE ES LO QUE USA EL SERVICE
        return ConsultingRoomDTO.builder()
                .id(cr.getId())
                .name(cr.getName())
                .address(cr.getAddress())
                .serviceHours(cr.getServiceHours())
                .build();

    }

    public static ConsultingRoom toEntity (ConsultingRoomDTO dto){


        if (dto == null) return null;

        //como el toEntity lo usa generalmente el create, no le ponemos el id

        return ConsultingRoom.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .serviceHours(dto.getServiceHours())
                .build();
    }
}
