package com.mycompany.proyecto2p;

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

    @FXML
    private void comenzarNuevaPartida(ActionEvent event) throws IOException {
        Ciudad ciudad = new Ciudad(txtNombreCiudad.getText(), txtNombreAlcalde.getText(), calcularPresupuesto());
        App.setRoot("Mundo");
    }
    
    //Método que a partir de los radioButton del menu selecciona el valor del presupuesto con el que se crea la ciudad
    public double calcularPresupuesto(){
        
        double presupuesto = 0;
        
        if(rdbttnFacil.isSelected()){
            
            presupuesto = Configuracion.PRESUPUESTO_INICIAL_FACIL;
        }  
        else if(rdbttnMedio.isSelected()){
            presupuesto = Configuracion.PRESUPUESTO_INICIAL_MEDIO;
        }
        else if(rdbttnDificil.isSelected()){
            presupuesto = Configuracion.PRESUPUESTO_INICIAL_DIFICIL;
        }
        
        return presupuesto; 

    }
    
}
