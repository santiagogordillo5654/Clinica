package co.edu.uniquindio.clinica.Modelo;

import lombok.*;

import java.time.LocalDateTime;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cita {
    private Paciente paciente;
    private String id;
    private LocalDateTime fecha ;
    private Servicio servicio;
    private Factura factura;
}
