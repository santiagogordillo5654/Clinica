package co.edu.uniquindio.clinica.Modelo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Servicio {
    private String id;
    private String nombre;
    private double precio;
    private String incluidoEn;
}