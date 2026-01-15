package com.example.TurneraMedica.dto.Patient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class PatientUpdateDTO {

    private String name;
    private String lastName;
    private String phone;
    private String email;
}
