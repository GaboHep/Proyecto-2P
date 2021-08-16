package com.mycompany.proyecto2p;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
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
    public void NuevaPartida() {
        flwPn.getChildren().clear();
        flwPn.setVgap(20);
        
        Label textoCiudad = new Label("Nombre de la Ciudad: ");
        Label textoAlcalde = new Label("Nombre del Alcalde: ");
        
        TextField nombreCiudad = new TextField();
        TextField nombreAlcalde = new TextField();
              
        RadioButton facil = new RadioButton("Fácil");
        RadioButton medio = new RadioButton("Medio");
        RadioButton dificil = new RadioButton("Difícil");
        
        FlowPane panel = new FlowPane(facil, medio, dificil);
        panel.setAlignment(Pos.CENTER);
        panel.setHgap(20);
        
        Button comenzar = new Button("Comenzar");
        Button regresar = new Button("Regresar");
        FlowPane panel2 = new FlowPane(regresar, comenzar);  
        panel2.setAlignment(Pos.CENTER);
        panel2.setHgap(100);
        
        flwPn.getChildren().add(textoCiudad);
        flwPn.getChildren().add(nombreCiudad);
        flwPn.getChildren().add(textoAlcalde);
        flwPn.getChildren().add(nombreAlcalde);
        flwPn.getChildren().add(panel);
        flwPn.getChildren().add(panel2);
    }
    
    @FXML
    public void CargarPartida() {
        flwPn.getChildren().clear();
        flwPn.setVgap(20);
        
        Label textCargar = new Label("Selecciona la partida");
        
        flwPn.getChildren().add(textCargar);
    }
    
}
