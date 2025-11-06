package com.example.pacientes.mapper;

import org.springframework.stereotype.Component;

import com.example.commons.dto.PacienteRequest;
import com.example.commons.dto.PacienteResponse;
import com.example.commons.mapper.CommonMapper;
import com.example.pacientes.entities.Pacientes;
import com.example.commons.enums.EstadoRegistro;

@Component
public class PacienteMapper implements CommonMapper<PacienteRequest, PacienteResponse, Pacientes>{

	@Override
	public PacienteResponse entityToResponse(Pacientes entity) {
		if(entity == null) return null;
		return new PacienteResponse(
				entity.getId(),
				String.join("", entity.getNombre(),
						entity.getApellidoPaterno(),
						entity.getApellidoMaterno()),
				entity.getEdad(),
				entity.getPeso(),
				entity.getEstatura(),
				entity.getIMC(),
				entity.getEmail(),
				entity.getTelefono(),
				entity.getDireccion(),
				entity.getNumeroExpediente(),
				entity.getEstadoPaciente().getDescripcion());
	}

	@Override
	public Pacientes requestToEntity(PacienteRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
