package com.example.commons.dto;

public record DatosPaciente(
		String nombre,
		String numExpediente,
		String edad,
		String peso,
		String estatura,
		Double imc,
		String telefono
) {}