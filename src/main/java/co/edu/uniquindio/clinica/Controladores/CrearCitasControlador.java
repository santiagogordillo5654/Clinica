package co.edu.uniquindio.clinica.Controladores;

import co.edu.uniquindio.clinica.Modelo.Cita;
import co.edu.uniquindio.clinica.Modelo.Clinica;
import co.edu.uniquindio.clinica.Modelo.Paciente;
import co.edu.uniquindio.clinica.Modelo.Servicio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.time.LocalDateTime;

public class CrearCitasControlador {

    @FXML
    private DatePicker datePicker;

    @FXML
    private ComboBox<Paciente> comboPacientes; // Combobox para seleccionar paciente

    @FXML
    private ComboBox<Servicio> comboServicios; // Combobox para seleccionar servicio

    @FXML
    private Button btnCrearCita;

    private final Clinica clinica;

    public CrearCitasControlador() {
        this.clinica = Clinica.getInstancia();
    }

    @FXML
    public void initialize() {
        // Lógica para llenar los comboBox con pacientes y servicios disponibles
        comboPacientes.getItems().addAll(clinica.listarPacientes());
        comboServicios.getItems().addAll(clinica.listarServicios());
    }

    //@FXML
    public void crearCita(ActionEvent e) {
        LocalDateTime fecha = datePicker.getValue().atStartOfDay(); // Convierte la fecha seleccionada a LocalDateTime
        Paciente paciente = comboPacientes.getValue();
        Servicio servicio = comboServicios.getValue();
        if (paciente != null && servicio != null) {
            try {
                Cita nuevaCita = new Cita();
                nuevaCita.setPaciente(paciente);
                nuevaCita.setFecha(fecha);
                nuevaCita.setServicio(servicio);
                clinica.agendarCita(nuevaCita);
                // Actualizar UI o mostrar mensaje de éxito
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
