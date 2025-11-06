package com.example.medicos.controllers;

import com.example.commons.controllers.CommonController;
import com.example.commons.dto.MedicoRequest;
import com.example.commons.dto.MedicoResponse;
import com.example.medicos.services.MedicoService;

import jakarta.validation.constraints.Positive;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class MedicoController extends CommonController<MedicoRequest, MedicoResponse, MedicoService>{
	public MedicoController(MedicoService service) {
		super(service);
	}
	
	@GetMapping("/filtrar")
	public ResponseEntity<List<MedicoResponse>> buscarPor(
			@RequestParam(required = false) String nombre,
			@RequestParam(required = false) String especialidad,
			@RequestParam(required = false) String disponibilidad){
		return ResponseEntity.ok(service.buscarPor(nombre, especialidad, disponibilidad));		
	}
	
	@GetMapping("/id-medico/{idMedico}/id-disponibilidad/{idDisponibilidad}")
	public ResponseEntity<MedicoResponse> actializarDisponibilidadMedico(
			@PathVariable @Positive(message = "el id del medico debe de ser positivo") Long idMedico,
			@PathVariable @Positive(message = "el id de disponibilidad debe de ser positivo") Long idDisponibilidad){
		return ResponseEntity.ok(service.actualizarDisponibilidad(idMedico, idDisponibilidad));		
	}
}
