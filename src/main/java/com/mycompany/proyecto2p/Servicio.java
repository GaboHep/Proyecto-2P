package com.mycompany.proyecto2p;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
    
    public static void llenarServicios() throws FileNotFoundException {
        
        try {
            FileReader archivo = new FileReader("/archivos/servicios.txt");
            BufferedReader buffer = new BufferedReader(archivo);
            
            String linea = buffer.readLine();
            buffer.readLine();
            
            while(linea != null) {
                
                String [] lineaSeparada = linea.split(",");
                String nombre = lineaSeparada[0];
                String ruta = lineaSeparada[1];
                double precioConstruccion = Double.parseDouble(lineaSeparada[2]);
                double precioMensual = Double.parseDouble(lineaSeparada[3]);
                
                listaServicios.add(new Servicio(nombre, ruta, precioConstruccion, precioMensual));
                
            }
            
        }
        
        catch (Exception e) {
            
        }
        
    }
    
}
