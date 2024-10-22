package co.edu.uniquindio.clinica.Controladores;

import co.edu.uniquindio.clinica.Modelo.Cita;
import co.edu.uniquindio.clinica.Modelo.Clinica;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class ListarCitasControlador {

    @FXML
    private TableView<Cita> tablaCitas;

    @FXML
    private TableColumn<Cita, String> colPaciente;

    @FXML
    private TableColumn<Cita, String> colFecha;

    @FXML
    private TableColumn<Cita, String> colServicio;

    private final Clinica clinica;

    public ListarCitasControlador() {
        this.clinica = Clinica.getInstancia();
    }

    @FXML
    public void initialize() {
        colPaciente.setCellValueFactory(new PropertyValueFactory<>("paciente.nombre")); // Asumiendo que hay un getter para nombre en Paciente
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colServicio.setCellValueFactory(new PropertyValueFactory<>("servicio.nombre")); // Asumiendo que hay un getter para nombre en Servicio

        // Cargar la lista de citas en la tabla
        actualizarTabla();
    }

    public void actualizarTabla() {
        List<Cita> citas = clinica.listarCitas();
        tablaCitas.getItems().clear();
        tablaCitas.getItems().addAll(citas);
    }
}

