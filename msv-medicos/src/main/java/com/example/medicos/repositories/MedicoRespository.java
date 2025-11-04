package com.example.medicos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.medicos.entities.Medico;
import java.util.List;
import java.util.Optional;

import com.example.commons.enums.EstadoRegistro;


public interface MedicoRespository extends JpaRepository<Medico,Long>, JpaSpecificationExecutor<Medico>{
	List<Medico> findByEstado(EstadoRegistro estado);
	Optional<Medico> findByIdAndEstado (Long id, EstadoRegistro estado);
	boolean existsByEmailIgnoreCaseAndEstado (String email, EstadoRegistro estado);
	boolean existsByTelefonoAndEstado (String telefono, EstadoRegistro estado);
	boolean existsByCedulaProfesionalIgnoreCaseAndEstado(String cedulaProfesional, EstadoRegistro estado);

}
