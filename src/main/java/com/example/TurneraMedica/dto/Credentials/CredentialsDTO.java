package com.example.TurneraMedica.dto.Credentials;

import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class CredentialsDTO {

    private String username;
    private String password;
}
