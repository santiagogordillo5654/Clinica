package co.edu.uniquindio.clinica.Controladores;
import co.edu.uniquindio.clinica.Modelo.Clinica;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Tab;

import java.net.URL;
import java.util.ResourceBundle;


public class PanelControlador2 implements Initializable {
    @FXML
    private Tab tab1;

    @FXML
    private Tab tab2;

    @FXML
    private Tab tab3;

    @FXML
    private Tab tab4;

    @FXML
    private Tab tab5;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
            cargarTab(tab1, "/registroPaciente.fxml");
            cargarTab(tab2, "/listaPacientes.fxml");
            cargarTab(tab3, "/crearCitas.fxml");
            cargarTab(tab4, "/listarCitas.fxml");
            cargarTab(tab5, "/serviciosDisponibles.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void cargarTab(Tab tab, String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent content = loader.load();
            tab.setContent(content);
        } catch (Exception e) {
            System.err.println("Error al cargar el FXML: " + fxmlPath);
            e.printStackTrace();
        }
    }
}

