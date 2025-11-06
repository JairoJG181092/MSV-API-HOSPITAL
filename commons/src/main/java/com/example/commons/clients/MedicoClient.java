package com.example.commons.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.commons.dto.MedicoResponse;

@FeignClient(name = "msv-medicos")
public interface MedicoClient {
	
	@GetMapping("/{id}")
	MedicoResponse obtenerMedicoPorId(@PathVariable Long id);
	
	@GetMapping("/validar/medico/{idMedico}")
    boolean tieneMedico(@PathVariable("idMedico") Long idMedico);

}
