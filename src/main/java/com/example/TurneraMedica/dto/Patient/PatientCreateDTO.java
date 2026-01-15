package com.example.TurneraMedica.dto.Patient;

import com.example.TurneraMedica.dto.Credentials.CredentialsDTO;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class PatientCreateDTO {

    private Long id;
    private String name;
    private String lastName;
    private String phone;
    private String dni;
    private String email;
    private CredentialsDTO credentials;
}
