package com.mycompany.proyecto2p;

import java.util.ArrayList;
import javafx.scene.control.TextField;

public class Partida {   
    
    public static Ciudad ciudad;
    
    public static ArrayList<Partida> listaPartida = new ArrayList<>();
    
    public Partida(Ciudad ciudad) {
        this.ciudad = ciudad;
        listaPartida.add(this);
    }
    
    public static void crearNuevaPartida(TextField txtNombreCiudad, TextField txtNombreAlcalde, int cantidad) {
        Ciudad ciudad = new Ciudad(txtNombreCiudad.getText(), txtNombreAlcalde.getText(), cantidad);
        Partida partida = new Partida(ciudad);
    }
}
