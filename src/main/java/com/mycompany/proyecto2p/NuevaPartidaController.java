package com.mycompany.proyecto2p;

import com.mycompany.proyecto2p.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class NuevaPartidaController implements Initializable {


    @FXML
    private TextField txtNombreCiudad;
    @FXML
    private TextField txtNombreAlcalde;
    @FXML
    private RadioButton rdbttnFacil;
    @FXML
    private ToggleGroup Dificultad;
    @FXML
    private RadioButton rdbttnMedio;
    @FXML
    private RadioButton rdbttnDificil;
    @FXML
    private Button bttnRegresar;
    @FXML
    private Button bttnComenzar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    private void regresarAlMenu(ActionEvent event) throws IOException {
        App.setRoot("Menu");
    }

}
