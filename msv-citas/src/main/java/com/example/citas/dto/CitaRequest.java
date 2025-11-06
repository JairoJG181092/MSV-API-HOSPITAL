package com.example.citas.dto;

import java.time.LocalDateTime;

public record CitaRequest(
		Long idPaciente,
		Long idMedico,
		LocalDateTime fechaCita,
		String sintomas,
		Long idEstadoCita
) {}