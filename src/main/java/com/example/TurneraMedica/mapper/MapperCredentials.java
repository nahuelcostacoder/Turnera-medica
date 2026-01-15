package com.example.TurneraMedica.mapper;

import com.example.TurneraMedica.dto.Credentials.CredentialsDTO;
import com.example.TurneraMedica.model.Credentials;

public class MapperCredentials {


    public static CredentialsDTO toDTO(Credentials credentials){

        if (credentials == null) return null;

        return CredentialsDTO.builder()
                .username(credentials.getUsername())
                .password(credentials.getPassword())
                .build();
    }

    public static Credentials toEntity(CredentialsDTO credentialsDTO){

        if (credentialsDTO == null) return null;


        return Credentials.builder()
                .username(credentialsDTO.getUsername())
                .password(credentialsDTO.getPassword())
                .build();
    }
}
