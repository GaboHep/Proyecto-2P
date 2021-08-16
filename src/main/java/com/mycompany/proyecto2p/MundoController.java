package com.mycompany.proyecto2p;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class MundoController implements Initializable {

    @FXML
    private FlowPane flwPn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
    
}
