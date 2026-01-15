package com.example.TurneraMedica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
@SuperBuilder
@DiscriminatorValue("DOCTOR")
public class Doctor extends User{

    private int licenceNumber;
    private String speciality;
}
