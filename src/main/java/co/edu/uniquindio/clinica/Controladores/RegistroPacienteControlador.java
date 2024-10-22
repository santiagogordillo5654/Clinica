package co.edu.uniquindio.clinica.Controladores;

import co.edu.uniquindio.clinica.Modelo.Clinica;
import co.edu.uniquindio.clinica.Modelo.Paciente;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class RegistroPacienteControlador implements Initializable {

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtEmail;

    @FXML
    private ComboBox<String> comboSuscripciones;

    private final Clinica clinica;

    public RegistroPacienteControlador() {
        this.clinica = Clinica.getInstancia();
    }

    public void registrarPaciente(ActionEvent event) {

        try {
            String cedula = txtCedula.getText();
            String nombre = txtNombre.getText();
            String telefono = txtTelefono.getText();
            String email = txtEmail.getText();
            String suscripcion = comboSuscripciones.getValue();

            String mensjae = clinica.registrarPaciente(cedula, nombre, telefono, email, suscripcion);
            // Actualizar UI o mostrar mensaje de éxito
        } catch (Exception e) {
            // Manejo de excepciones, mostrar mensaje de error
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboSuscripciones.setItems(FXCollections.observableArrayList(clinica.obtenerSuscripciones()));
    }
}
