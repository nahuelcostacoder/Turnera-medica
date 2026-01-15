package com.example.TurneraMedica.service;

import com.example.TurneraMedica.dto.ConsultingRoom.ConsultingRoomDTO;

import java.util.List;


public interface IConsultingRoomService {

    List<ConsultingRoomDTO> findAllConsultingRooms();
    ConsultingRoomDTO findById(Long id);
    ConsultingRoomDTO createConsultingRoom(ConsultingRoomDTO consultorioDTO);
    ConsultingRoomDTO updateConsultingRoom(Long id, ConsultingRoomDTO consultorioDTO);
    void deleteConsultingRoom(Long id);
}
