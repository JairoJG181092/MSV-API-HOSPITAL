package com.example.commons.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msv-citas")
public interface CitaClient {
	@GetMapping("/api/citas/validar/paciente/{idPaciente}")
    boolean tienePaciente(@PathVariable("idPaciente") Long idPaciente);
}
