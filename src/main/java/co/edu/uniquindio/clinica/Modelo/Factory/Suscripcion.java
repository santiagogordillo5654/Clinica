package co.edu.uniquindio.clinica.Modelo.Factory;

import co.edu.uniquindio.clinica.Modelo.Factura;
import co.edu.uniquindio.clinica.Modelo.Servicio;

import java.util.List;

public interface Suscripcion {
    String getNombre();
    List<Servicio> getServiciosDisponibles();
    Factura generarFacturaCobro(Servicio servicio);
}
