package com.mycompany.proyecto2p;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

public class MenuController implements Initializable {

    @FXML
    private FlowPane flwPn;
    @FXML
    private Button bttnNuevaPartida;
    @FXML
    private Button bttnCargarPartida;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    @FXML
    public void NuevaPartida() throws IOException {
        App.setRoot("NuevaPartida");
    }
    
    @FXML
    public void CargarPartida() throws IOException {
        Ciudad.deserializarCiudad();
        App.setRoot("Mundo");
    }
    
}
