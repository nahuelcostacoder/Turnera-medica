package com.example.TurneraMedica.dto.Doctor;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class DoctorDTO {

    private Long id;
    private String name;
    private String lastName;
    private String phone;
    private String dni;
    private int licenceNumber;
    private String speciality;

    //sin las credentials


}
