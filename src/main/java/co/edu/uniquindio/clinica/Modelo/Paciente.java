package co.edu.uniquindio.clinica.Modelo;

import co.edu.uniquindio.clinica.Modelo.Factory.Suscripcion;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class Paciente {

    private String telefono;
    private String nombre;
    private String cedula;
    private String email;
    private Suscripcion suscripcion;
}
