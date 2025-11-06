package com.example.citas.dto;

import java.time.LocalDateTime;

import com.example.commons.dto.DatosMedico;
import com.example.commons.dto.DatosPaciente;

public record CitaResponse(
		Long id,
		DatosPaciente paciente,
		DatosMedico medico,
		LocalDateTime fechaCita,
		String sintomas,
		String estadoCita
) {}