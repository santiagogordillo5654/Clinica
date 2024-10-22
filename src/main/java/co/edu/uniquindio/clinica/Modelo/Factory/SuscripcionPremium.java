package co.edu.uniquindio.clinica.Modelo.Factory;

import co.edu.uniquindio.clinica.Modelo.Factura;
import co.edu.uniquindio.clinica.Modelo.Servicio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SuscripcionPremium implements Suscripcion {

    private List<Servicio> serviciosPremium;

    public SuscripcionPremium() {
        this.serviciosPremium = new ArrayList<>();
        inicializarServiciosPremium();
    }

    @Override
    public String getNombre() {
        return "Premium";
    }

    @Override
    public List<Servicio> getServiciosDisponibles() {
        return serviciosPremium;
    }

    @Override
    public Factura generarFacturaCobro(Servicio servicio) {
        double total = servicio.getPrecio();
        double descuento = 0.0;

        // Si el servicio está incluido en la suscripción premium, se aplica descuento total
        if (serviciosPremium.contains(servicio)) {
            descuento = total;
            total = 0.0; // El servicio es gratuito en la suscripción premium
        }

        return Factura.builder()
                .id("FAC-" + servicio.getId())
                .fecha(LocalDate.now())
                .subTotal(servicio.getPrecio())
                .Total(total)
                .build();
    }

    private void inicializarServiciosPremium() {
        // Servicios de la suscripción básica
        serviciosPremium.add(Servicio.builder().id("001").nombre("Consulta General").precio(100.0).build());
        serviciosPremium.add(Servicio.builder().id("002").nombre("Examen de Sangre").precio(50.0).build());

        // Servicios adicionales de la suscripción premium
        serviciosPremium.add(Servicio.builder().id("003").nombre("Cardiología").precio(200.0).build());
        serviciosPremium.add(Servicio.builder().id("004").nombre("Terapia Física").precio(150.0).build());
    }
}
