package com.example.citas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.citas.entities.Citas;
import java.util.List;
import java.util.Optional;

import com.example.commons.enums.EstadoRegistro;


@Repository
public interface CitaRepository extends JpaRepository<Citas, Long>{
	List<Citas> findByEstadoRegistro(EstadoRegistro estadoRegistro);
	Optional<Citas> findByIdAndEstadoRegistro(Long id, EstadoRegistro estadoRegistro);
	
}
