package com.example.TurneraMedica.model;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
@Builder
public class Credentials {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    User user;
}
