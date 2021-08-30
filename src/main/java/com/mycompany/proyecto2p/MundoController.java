package com.mycompany.proyecto2p;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MundoController implements Initializable {

    @FXML
    private BorderPane borderPane;
    @FXML
    private Label lblTiempo;
    @FXML
    private Label lblPresupuesto;
    @FXML
    private Label lblNombreCiudad;
    @FXML
    private Label lblNombreAlcalde;
    @FXML
    private VBox vboxServicios;
    @FXML
    private ComboBox cbServicios;
    @FXML
    private ImageView vistaPrevia;
    @FXML
    private Label infoVistaPrevia;
    
    public Ciudad ciudad=Ciudad.ciudadUtilizada;

    @Override

    public void initialize(URL url, ResourceBundle rb) {       
        Servicio.llenarServicios();
        llenarTerreno(8, 8);
        cbServicios.getItems().addAll(Servicio.listaServicios);
        
        lblNombreCiudad.setText(ciudad.getNombre());
        lblNombreAlcalde.setText(ciudad.getNombreAlcalde());
        
        
    }
    /*
    public void controlarTiempo(){
        while(true){
            try{
                Thread.sleap()
            }
        }
    }*/
    
    public void llenarTerreno(int Columnas, int Filas) {
              
        GridPane gridpane = new GridPane();
         
        
        if (Columnas > 0 && Filas > 0) {
            
            
            Image grassTile = new Image("/servicios/grassTile.png", 50, 50, true, true);
                       
            
            for (int x = 0; x < Columnas; x++) {
                for (int y = 0; y < Filas; y++) {
                    StackPane stack=new StackPane();
                    ImageView imgvw = new ImageView(grassTile);
                    
                    stack.setOnMouseClicked(t->construirServicios(stack));
                    stack.getChildren().add(imgvw);
                    gridpane.add(stack, x, y);
                }
            }
        }
        
        borderPane.setCenter(gridpane);
        borderPane.setAlignment(gridpane,Pos.CENTER);
        
    }
    
    public void construirServicios(StackPane s){
        Servicio ser=(Servicio)cbServicios.getValue();
        s.getChildren().add(new ImageView(new Image(ser.getRuta(),45,45,true,true)));
        
        
       
    }
    
    public void establecerCiudad(Ciudad ciudad){
        this.ciudad=ciudad;
    }
    
    public void vistaPrevia(){
        
        Servicio s=(Servicio)cbServicios.getValue();
        Image imagen=new Image(s.getRuta());
        vistaPrevia.setImage(imagen);
        infoVistaPrevia.setText("Precio construccion: "+s.getPrecioConstruccion()+"\nPrecio Mantenimiento: "+s.getPrecioMensual());
    }
       
}


