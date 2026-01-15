package com.example.TurneraMedica.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "users") //user es palabra reservada de la bd
@Inheritance(strategy = InheritanceType.JOINED) //usa joins como haciamos en sql
@DiscriminatorColumn(name = "user_type") //crea una columna de tipo usertype que va a ser Patient o Doctor
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String phone;
    private String dni;

    @OneToOne(fetch = FetchType.LAZY)
    private Credentials credentials;

}
