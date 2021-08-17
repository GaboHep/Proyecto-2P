package com.mycompany.proyecto2p;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
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
        
        Thread hiloDelTiempo = new Thread(() -> transcursoDelTiempo(tiempo));
        
        hiloDelTiempo.start();
        
        fillGrid(5, 5);
    }
    
    public void fillGrid(int Columns, int Rows) {
        
        flwPn.setAlignment(Pos.CENTER);
        
        GridPane gridpane = new GridPane();
        
        if (Columns > 0 && Rows > 0) {
            
            Image grassTile = new Image("/assets/grassTile.png", 50, 50, true, true);
            
            for (int x = 0; x < Columns; x++) {
                for (int y = 0; y < Rows; y++) {
                    ImageView imgvw = new ImageView(grassTile);
                    gridpane.add(imgvw, x, y);
                }
            }
        }
        flwPn.getChildren().add(gridpane);
    }
    
    public void transcursoDelTiempo(Tiempo tiempo) {
        
        while (true) {
            try {
                Platform.runLater(() -> lblTiempo.setText(tiempo.getFecha().toString()));
                tiempo.siguienteDia();
                Thread.sleep(5000);
            }
            catch(InterruptedException ex) {
                
            }
        }
    }
    
}
