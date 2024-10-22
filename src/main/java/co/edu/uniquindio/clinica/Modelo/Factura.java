package co.edu.uniquindio.clinica.Modelo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Builder
@Getter
@Setter
public class Factura {
    private LocalDate fecha;
    private String id;
    private double Total;
    private double subTotal;
}
