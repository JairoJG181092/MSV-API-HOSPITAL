package com.example.citas.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.citas.dto.CitaRequest;
import com.example.citas.dto.CitaResponse;
import com.example.citas.entities.Citas;
import com.example.citas.enums.EstadoCita;
import com.example.citas.mappers.CitaMapper;
import com.example.citas.repositories.CitaRepository;
import com.example.commons.clients.MedicoClient;
import com.example.commons.clients.PacienteClient;
import com.example.commons.dto.MedicoResponse;
import com.example.commons.dto.PacienteResponse;
import com.example.commons.enums.EstadoRegistro;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class CitaServiceImpl implements CitaService{
	private final CitaRepository citaRepository;
	private final CitaMapper citaMapper;
	private final MedicoClient medicoClient;
	private final PacienteClient pacienteClient;
	
	@Override
	@Transactional(readOnly = true)
	public List<CitaResponse> listar() {
		log.info("listado de todas las citas solicitadas");
		return citaRepository.findByEstadoRegistro(EstadoRegistro.ACTIVO).stream()
				.map(citaMapper::entityToResponse).toList();
	}

	@Override
	@Transactional(readOnly = true)
	public CitaResponse obtenerPorId(Long id) {
		return citaMapper.entityToResponse(getCitaOrThrow(id));
	}

	@Override
	public CitaResponse registrar(CitaRequest request) {
		PacienteResponse paciente = pacienteClient.obtenerPacientePorId(request.idPaciente());
		MedicoResponse medico = medicoClient.obtenerMedicoPorId(request.idMedico());
		Citas cita = citaMapper.requestToEntity(request, EstadoCita.PENDIENTE);
		cita.setEstadoRegistro(EstadoRegistro.ACTIVO);
		log.info("Registrando nueva cita {}", request);
		cita = citaRepository.save(cita);
		log.info("cita registrada con exito: {}", cita);
		return citaMapper.entityToResponse(cita);
	}

	@Override
	public CitaResponse actualizar(CitaRequest request, Long id) {
		Citas cita = getCitaOrThrow(id);
		
		PacienteResponse paciente = pacienteClient.obtenerPacientePorId(request.idPaciente());
		MedicoResponse medico = medicoClient.obtenerMedicoPorId(request.idMedico());
		
		cita.setIdPaciente(request.idPaciente());
		cita.setIdMedico(request.idMedico());
		
		EstadoCita estado = EstadoCita.fromCodigo(request.idEstadoCita());
		cita.setEstadoCita(estado);
		
		
		cita.setFechaCita(request.fechaCita());
		cita.setSintomas(request.sintomas());
		log.info("Actualizando Cita: {}", cita.getId());
		cita = citaRepository.save(cita);
		log.info("Cita actualizada: {}", cita.getId());
		return null;
	}

	@Override
	public void eliminar(Long id) {
		Citas cita = getCitaOrThrow(id);
		cita.setEstadoRegistro(EstadoRegistro.ELIMINADO);
		citaRepository.save(cita);
		log.info("Cita con id {} ha sido marcada como elminada");
		
	}
	
	@Transactional(readOnly = true)
	private Citas getCitaOrThrow(Long id) {
		log.info("Buscando Cita con id: {}", id);
		return citaRepository.findByIdAndEstadoRegistro(id, EstadoRegistro.ACTIVO).orElseThrow(()->
		new NoSuchElementException("Cita no encontrado con el id " + id));
		
	}

}
