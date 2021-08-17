package com.mycompany.proyecto2p;

import javafx.scene.control.TextField;

public class Partida {
    public static Ciudad ciudad;
    
    public void crearCiudad(TextField txtNombreCiudad, TextField txtNombreAlcalde, int cantidad) {
        Ciudad ciudad = new Ciudad(txtNombreCiudad.getText(), txtNombreAlcalde.getText(), cantidad);
        this.ciudad = ciudad;
    }    
}
