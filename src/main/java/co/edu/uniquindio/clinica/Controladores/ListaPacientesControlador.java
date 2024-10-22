package co.edu.uniquindio.clinica.Controladores;

import co.edu.uniquindio.clinica.Modelo.Clinica;
import co.edu.uniquindio.clinica.Modelo.Paciente;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ListaPacientesControlador implements Initializable {

    @FXML
    private TableView<Paciente> tablaPacientes;

    @FXML
    private TableColumn<Paciente, String> colCedula;

    @FXML
    private TableColumn<Paciente, String> colNombre;

    @FXML
    private TableColumn<Paciente, String> colTelefono;

    @FXML
    private TableColumn<Paciente, String> colEmail;

    @FXML
    private TableColumn<Paciente, String> colSuscripcion;

    private final Clinica clinica;

    public ListaPacientesControlador() {
        this.clinica = Clinica.getInstancia();
    }

    public void actualizarTabla() {
        List<Paciente> pacientes = clinica.listarPacientes();
        tablaPacientes.setItems(FXCollections.observableArrayList(pacientes));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colCedula.setCellValueFactory( cell -> new SimpleStringProperty(cell.getValue().getCedula()));
        colNombre.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getNombre()));
        colTelefono.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getTelefono()));
        colEmail.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getEmail()));
        colSuscripcion.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getSuscripcion().getNombre()));

        // Cargar la lista de pacientes en la tabla
        actualizarTabla();
    }
}
