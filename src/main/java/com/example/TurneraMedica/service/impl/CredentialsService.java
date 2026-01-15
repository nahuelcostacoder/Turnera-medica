package com.example.TurneraMedica.service.impl;

import com.example.TurneraMedica.dto.Credentials.CredentialsDTO;
import com.example.TurneraMedica.mapper.MapperCredentials;
import com.example.TurneraMedica.model.Credentials;
import com.example.TurneraMedica.repository.CredentialsRepository;
import com.example.TurneraMedica.service.ICredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CredentialsService implements ICredentialsService {

    @Autowired
    private CredentialsRepository repoCredentials;

    @Override
    public Credentials createCredentials(CredentialsDTO credentialsDTO) {

        Credentials credentials = MapperCredentials.toEntity(credentialsDTO);

        return repoCredentials.save(credentials);
    }
}
