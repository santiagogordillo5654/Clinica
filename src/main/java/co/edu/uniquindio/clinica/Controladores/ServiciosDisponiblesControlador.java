package co.edu.uniquindio.clinica.Controladores;

import co.edu.uniquindio.clinica.Modelo.Clinica;
import co.edu.uniquindio.clinica.Modelo.Servicio;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.List;

public class ServiciosDisponiblesControlador {

    @FXML
    private ListView<Servicio> listViewServicios;

    private final Clinica clinica;

    public ServiciosDisponiblesControlador() {
        this.clinica = Clinica.getInstancia();
    }

    @FXML
    public void initialize() {
        List<Servicio> servicios = clinica.listarServicios();
        listViewServicios.getItems().addAll(servicios);
    }
}
