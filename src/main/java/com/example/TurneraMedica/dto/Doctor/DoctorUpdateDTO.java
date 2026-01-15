package com.example.TurneraMedica.dto.Doctor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class DoctorUpdateDTO {

    private String name;
    private String lastName;
    private String phone;
    private String speciality;
}
