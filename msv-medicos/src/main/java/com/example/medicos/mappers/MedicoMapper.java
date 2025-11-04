package com.example.medicos.mappers;

import org.springframework.stereotype.Component;

import com.example.commons.dto.MedicoRequest;
import com.example.commons.dto.MedicoResponse;
import com.example.commons.enums.DisponibilidadMedico;
import com.example.commons.enums.EspecialidadMedico;
import com.example.commons.mapper.CommonMapper;
import com.example.medicos.entities.Medico;

@Component
public class MedicoMapper implements CommonMapper<MedicoRequest, MedicoResponse, Medico>{

	@Override
	public MedicoResponse entityToResponse(Medico entity) {
		if(entity == null) return null;
		return new MedicoResponse(
				entity.getId(),
				String.join("", entity.getNombre(),
						entity.getApellidoPaterno(),
						entity.getApellidoMaterno()),
				entity.getEdad(),
				entity.getEmail(),
				entity.getTelefono(),
				entity.getCedulaProfesional(),
				entity.getEspecialidad().getDescripcion(),
				entity.getDisponibilidad().getDescripcion());
				
	}

	@Override
	public Medico requestToEntity(MedicoRequest request) {
		if(request == null )return null;
		Medico medico = new Medico();
		medico.setNombre(request.nombre());
		medico.setApellidoPaterno(request.apellidoPaterno());
		medico.setApellidoMaterno(request.apellidoMaterno());
		medico.setEdad(request.edad());
		medico.setEmail(request.email());
		medico.setTelefono(request.telefono());
		medico.setCedulaProfesional(request.cedulaProfesional());
		medico.setEspecialidad(null);
		medico.setDisponibilidad(null);
		return medico;
	}
	
	public Medico requestToEntity(MedicoRequest request, EspecialidadMedico especialidadMedico, DisponibilidadMedico disponibilidadMedico) {
		if(request == null) return null;
		Medico medico = requestToEntity(request);
		medico.setEspecialidad(especialidadMedico);
		medico.setDisponibilidad(disponibilidadMedico);
		return medico;
	}
}
