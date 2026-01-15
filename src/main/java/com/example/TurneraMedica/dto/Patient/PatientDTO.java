package com.example.TurneraMedica.dto.Patient;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class PatientDTO {

    //como esto lo construimos nosotros, al pasarlo a entity con el super
    //ya se da cuenta que es parte del padre
    private Long id;
    private String name;
    private String lastName;
    private String phone;
    private String dni;
    private String email;
}
