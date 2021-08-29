package com.mycompany.proyecto2p;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class MundoController implements Initializable {

    @FXML
    private BorderPane borderPane;
    @FXML
    private Label lblTiempo;
    @FXML
    private Label lblPresupuesto;
    @FXML
    private HBox hboxInfo;

    @Override

    public void initialize(URL url, ResourceBundle rb) {
        //Acción que inicia el tiempo de la ciudad      

        llenarTerreno(8, 8);
    }
    
   /* public void controlarTiempo(){
        Tiempo tiempo = new Tiempo();
        
        Thread hiloDelTiempo = new Thread(() -> Tiempo.transcursoDelTiempo(lblTiempo, tiempo));
        
        hiloDelTiempo.start();

    }*/
    
    public void llenarTerreno(int Columnas, int Filas) {
              
        GridPane gridpane = new GridPane();
        
        if (Columnas > 0 && Filas > 0) {
            
            
            Image grassTile = new Image("/servicios/grassTile.png", 50, 50, true, true);
                       
            
            for (int x = 0; x < Columnas; x++) {
                for (int y = 0; y < Filas; y++) {
                    StackPane stack=new StackPane();
                    ImageView imgvw = new ImageView(grassTile);
                                                          
                    stack.getChildren().addAll(imgvw);
                    gridpane.add(stack, x, y);
                }
            }
        }
        
        borderPane.setCenter(gridpane);
        
       
        
    }
   
}

