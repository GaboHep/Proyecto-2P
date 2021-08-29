package com.mycompany.proyecto2p;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class MundoController implements Initializable {

    @FXML
    private FlowPane flwPn;
    @FXML
    private Label lblTiempo;
    @FXML
    private Label lblPresupuesto;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Tiempo tiempo = new Tiempo();
        
        Thread hiloDelTiempo = new Thread(() -> Tiempo.transcursoDelTiempo(lblTiempo, tiempo));
        
        hiloDelTiempo.start();
        
        llenarTerreno(5, 5);
    }
    
    public void llenarTerreno(int Columnas, int Filas) {
        
        flwPn.setAlignment(Pos.CENTER);
        
        GridPane gridpane = new GridPane();
        
        if (Columnas > 0 && Filas > 0) {
            
            Image grassTile = new Image("/servicios/grassTile.png", 50, 50, true, true);
            
            for (int x = 0; x < Columnas; x++) {
                for (int y = 0; y < Filas; y++) {
                    ImageView imgvw = new ImageView(grassTile);
                    gridpane.add(imgvw, x, y);
                }
            }
        }
        flwPn.getChildren().add(gridpane);
    }
   
}
