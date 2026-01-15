package com.example.TurneraMedica.dto.Doctor;

import com.example.TurneraMedica.dto.Credentials.CredentialsDTO;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class DoctorCreateDTO {

    private Long id;
    private String name;
    private String lastName;
    private String phone;
    private String dni;
    private int licenceNumber;
    private String speciality;

    private CredentialsDTO credentials;
}
