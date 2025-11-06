package com.example.pacientes.repositories;

import com.example.pacientes.entities.Pacientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacientesRepository extends JpaRepository<Pacientes, Long> {
    boolean existsByEmail(String email);
}
