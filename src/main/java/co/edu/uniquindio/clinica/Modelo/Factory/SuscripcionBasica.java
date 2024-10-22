package co.edu.uniquindio.clinica.Modelo.Factory;

import co.edu.uniquindio.clinica.Modelo.Factura;
import co.edu.uniquindio.clinica.Modelo.Servicio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SuscripcionBasica implements Suscripcion {

    private List<Servicio> serviciosBasicos;

    public SuscripcionBasica() {
        this.serviciosBasicos = new ArrayList<>();
        inicializarServiciosBasicos();
    }

    @Override
    public String getNombre() {
        return "Básica";
    }

    @Override
    public List<Servicio> getServiciosDisponibles() {
        return serviciosBasicos;
    }

    @Override
    public Factura generarFacturaCobro(Servicio servicio) {
        double total = servicio.getPrecio();
        double descuento = 0.0;

        // Si el servicio está incluido en la suscripción básica, se aplica descuento total
        if (serviciosBasicos.contains(servicio)) {
            descuento = total;
            total = 0.0; // El servicio es gratuito en la suscripción básica
        }

        return Factura.builder()
                .id("FAC-" + servicio.getId())
                .fecha(LocalDate.now())
                .subTotal(servicio.getPrecio())
                .Total(total)
                .build();
    }

    private void inicializarServiciosBasicos() {
        serviciosBasicos.add(Servicio.builder().id("001").nombre("Consulta General").precio(100.0).build());
        serviciosBasicos.add(Servicio.builder().id("002").nombre("Examen de Sangre").precio(50.0).build());
    }
}
