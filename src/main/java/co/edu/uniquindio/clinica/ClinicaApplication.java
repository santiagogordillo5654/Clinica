package co.edu.uniquindio.clinica;

import co.edu.uniquindio.clinica.Controladores.PanelControlador2;
import co.edu.uniquindio.clinica.Modelo.Clinica;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ClinicaApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Crear la instancia de la lógica de la clínica

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/panel.fxml"));

        // Cargar la vista y establecer la escena
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Clínica");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
