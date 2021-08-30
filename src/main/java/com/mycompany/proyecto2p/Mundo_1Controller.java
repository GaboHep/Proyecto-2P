package com.mycompany.proyecto2p;

import com.mycompany.proyecto2p.Servicio;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

public class Mundo_1Controller implements Initializable {

    @FXML
    private FlowPane flwPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        for (Servicio servicio: Servicio.listaServicios) {
            
            ImageView imagen = new ImageView(new Image(servicio.getRuta()));
            Label texto = new Label(servicio.getNombre());
            
            Pane panel = new Pane(imagen, texto);
            flwPane.getChildren().add(panel);
            
        }
    }    
    
}
