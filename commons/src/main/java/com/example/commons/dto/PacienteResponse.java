package com.example.commons.dto;

import com.example.commons.enums.EstadoRegistro;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PacienteResponse {
    private Long id;
    private String nombreCompleto;
    private Short edad;
    private Double peso;
    private Double estatura;
    private Double imc;
    private String email;
    private String telefono;
    private String direccion;
    private String numeroExpediente;
    private EstadoRegistro estadoPaciente;
}
