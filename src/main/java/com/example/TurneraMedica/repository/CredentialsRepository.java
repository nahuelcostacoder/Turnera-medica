package com.example.TurneraMedica.repository;

import com.example.TurneraMedica.model.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialsRepository extends JpaRepository<Credentials, Long> {
}
