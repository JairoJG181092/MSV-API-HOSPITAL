package com.example.pacientes.controller;

import com.example.commons.dto.PacienteRequest;
import com.example.commons.dto.PacienteResponse;
import com.example.pacientes.services.PacientesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping
public class PacientesController {

    private final PacientesService pacientesService;

    public PacientesController(PacientesService pacientesService) {
        this.pacientesService = pacientesService;
    }

    // 🔹 Crear paciente
    @PostMapping
    public ResponseEntity<PacienteResponse> crear(@Valid @RequestBody PacienteRequest request) {
        return ResponseEntity.ok(pacientesService.registrar(request));
    }

    // 🔹 Obtener todos
    @GetMapping
    public ResponseEntity<List<PacienteResponse>> listar() {
        return ResponseEntity.ok(pacientesService.listar());
    }

    // 🔹 Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponse> obtenerPorId(@PathVariable Long id) {
        PacienteResponse paciente = pacientesService.obtenerPorId(id);
        if (paciente == null) {
            // ⛔️ Esto será capturado automáticamente por GlobalExceptionHandler
            throw new NoSuchElementException("No se encontró el paciente con ID " + id);
        }
        return ResponseEntity.ok(paciente);
    }

    // 🔹 Eliminar paciente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
    	 pacientesService.eliminar(id);
    	    return ResponseEntity.noContent().build(); // HTTP 204
    }

    // 🔹 Actualizar paciente
    @PutMapping("/{id}")
    public ResponseEntity<PacienteResponse> actualizar(@PathVariable Long id, @Valid @RequestBody PacienteRequest request) {
        try {
            return ResponseEntity.ok(pacientesService.actualizar( request, id));
        } catch (IllegalArgumentException e) {
            // ⛔️ Esto también se manda al GlobalExceptionHandler
            throw new IllegalArgumentException("Error al actualizar: " + e.getMessage());
        }
    }
    
    
}
