package com.example.TurneraMedica.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
@SuperBuilder
@DiscriminatorValue("PATIENT")
public class Patient extends User{

    private String email;
}
