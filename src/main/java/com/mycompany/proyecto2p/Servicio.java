package com.mycompany.proyecto2p;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Servicio {
    
    public static ArrayList<Servicio> listaServicios = new ArrayList<>();
    
    private String nombre;
    private String ruta;
    private double precioConstruccion;
    private double precioMensual;

    public Servicio(String nombre, String ruta, double precioConstruccion, double precioMensual) {
        this.nombre = nombre;
        this.ruta = ruta;
        this.precioConstruccion = precioConstruccion;
        this.precioMensual = precioMensual;
    }
    
    public static void llenarServicios(){
        
        try(BufferedReader lector=new BufferedReader(new InputStreamReader(App.class.getResourceAsStream("archivos/servicios.txt")))) {
            lector.readLine();
            String linea = lector.readLine();
            
            
            while(linea != null) {
                
                String [] lineaSeparada = linea.split(",");
                String nombre = lineaSeparada[0];
                String ruta = lineaSeparada[1];
                double precioConstruccion = Double.parseDouble(lineaSeparada[2]);
                double precioMensual = Double.parseDouble(lineaSeparada[3]);
                
                listaServicios.add(new Servicio(nombre, ruta, precioConstruccion, precioMensual));
                
                linea=lector.readLine();
            }
            
        } 
        catch (IOException ex) {
            
        }
            
        
        
    }
    
    // ponerServicio
    // quitarServicio
    
}
