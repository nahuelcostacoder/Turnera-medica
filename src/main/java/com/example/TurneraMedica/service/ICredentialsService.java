package com.example.TurneraMedica.service;

import com.example.TurneraMedica.dto.Credentials.CredentialsDTO;
import com.example.TurneraMedica.model.Credentials;


public interface ICredentialsService {

    public Credentials createCredentials(CredentialsDTO credentialsDTO);
    //retornamos un credentials para que lo pueda usar el service del paciente y medico
    //no es para un endpoint.
}
