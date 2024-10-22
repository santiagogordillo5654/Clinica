package co.edu.uniquindio.clinica.Modelo;

import co.edu.uniquindio.clinica.Modelo.Factory.Suscripcion;
import co.edu.uniquindio.clinica.Modelo.Factory.SuscripcionBasica;
import co.edu.uniquindio.clinica.Modelo.Factory.SuscripcionPremium;
import co.edu.uniquindio.clinica.Utils.EnvioEmail;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Clinica {

    private static Clinica INSTANCIA; // Declaración del Singleton
    private List<Paciente> pacientes;
    private List<Cita> citas;
    private List<Servicio> servicios;

    private Clinica() {
        pacientes = new ArrayList<>();
        citas = new ArrayList<>();
        servicios = new ArrayList<>();

        crearDatosPrueba();
    }

    private void crearDatosPrueba() {

        servicios.add(Servicio.builder().id("001").nombre("Consulta General").precio(100.0).build());
        servicios.add(Servicio.builder().id("002").nombre("Examen de Sangre").precio(50.0).build());
        // Servicios adicionales de la suscripción premium
        servicios.add(Servicio.builder().id("003").nombre("Cardiología").precio(200.0).build());
        servicios.add(Servicio.builder().id("004").nombre("Terapia Física").precio(150.0).build());

    }

    public static Clinica getInstancia() {
        if (INSTANCIA == null) {
            INSTANCIA = new Clinica();
        }
        return INSTANCIA;
    }
    // Registro de pacientes (sin permitir duplicados con la misma cédula)
    public String registrarPaciente(String cedula, String nombre, String telefono, String email, String suscripcion) throws Exception {

        Suscripcion nueva = switch(suscripcion) {
            case "Básica" -> new SuscripcionBasica();
            case "Premium" -> new SuscripcionPremium();
            default -> throw new Exception("No se puede registrar el paciente");
        };

        Paciente nuevoPaciente = Paciente.builder()
                .cedula(cedula)
                .nombre(nombre)
                .telefono(telefono)
                .email(email)
                .suscripcion(nueva)
                .build();

        pacientes.add(nuevoPaciente);
        return "Paciente registrado exitosamente.";
    }

    // Listado de pacientes
    public List<Paciente> listarPacientes() {
        System.out.println(pacientes);
        return pacientes;
    }

    // Agendamiento de citas (validar que no se cruce con otra cita en el mismo horario)
    public String agendarCita(Cita nuevaCita) throws Exception {
        for (Cita cita : citas) {
            if (cita.getFecha().equals(nuevaCita.getFecha()) && cita.getPaciente().equals(nuevaCita.getPaciente())) {
                throw new Exception("El paciente ya tiene una cita en el mismo horario.");
            }
        }
        citas.add(nuevaCita);
        // Aquí se podría llamar a una función externa para enviar un email (fuera del alcance actual)

        return "Cita agendada exitosamente.";
    }

    // Visualización de citas
    public List<Cita> listarCitas() {
        return citas;
    }

    // Cancelación de citas
    public String cancelarCita(String idCita) throws Exception {
        Cita citaACancelar = buscarCitaPorId(idCita);
        citas.remove(citaACancelar);
        return "Cita cancelada exitosamente.";
    }

    // Generación de factura
    public Factura generarFactura(Paciente paciente, Servicio servicio) throws Exception {
        if (!pacientes.contains(paciente)) {
            throw new Exception("El paciente no está registrado en la clínica.");
        }

        Suscripcion suscripcion = paciente.getSuscripcion();
        Factura factura = suscripcion.generarFacturaCobro(servicio);

        EnvioEmail.enviarNotificacion(paciente.getEmail(), "Se ha agendado un nueva cita", "");
        return factura;
    }

    // Listado de servicios disponibles
    public List<Servicio> listarServicios() {
        return servicios;
    }

    // Búsqueda de paciente por cédula
    private Optional<Paciente> buscarPacientePorCedula(String cedula) {
        return pacientes.stream()
                .filter(paciente -> paciente.getCedula().equals(cedula))
                .findFirst();
    }

    // Búsqueda de cita por ID
    private Cita buscarCitaPorId(String idCita) throws Exception {
        return citas.stream()
                .filter(cita -> cita.getId().equals(idCita))
                .findFirst()
                .orElseThrow(() -> new Exception("No se encontró ninguna cita con el ID proporcionado."));
    }

    public List<String> obtenerSuscripciones(){
        return List.of("Básica", "Premium");
    }

}
