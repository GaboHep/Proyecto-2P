package com.mycompany.proyecto2p;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class CargarPartidaController implements Initializable {


    @FXML
    private Button bttnRegresar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
    @FXML
    private void regresarAlMenu(ActionEvent event) throws IOException {
        App.setRoot("Menu");
    }

}
