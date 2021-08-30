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
          

    public static void llenarServicios() throws FileNotFoundException {

        try {
            FileReader archivo = new FileReader("/archivos/servicios.txt");
            BufferedReader buffer = new BufferedReader(archivo);

            String linea = buffer.readLine();
            buffer.readLine();


            while(linea != null) {

                String [] lineaSeparada = linea.split(",");
                String nombre = lineaSeparada[0].strip();
                String ruta = lineaSeparada[1].strip();
                double precioConstruccion = Double.parseDouble(lineaSeparada[2]);
                double precioMensual = Double.parseDouble(lineaSeparada[3]);

                listaServicios.add(new Servicio(nombre, ruta, precioConstruccion, precioMensual));
  
                linea=buffer.readLine();
            }
            
        } 
        catch (IOException ex) {
            
        }
     }

    public static ArrayList<Servicio> getListaServicios() {
        return listaServicios;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public double getPrecioConstruccion() {
        return precioConstruccion;
    }

    public double getPrecioMensual() {
        return precioMensual;
    }



}
