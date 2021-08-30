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
        try(BufferedReader r=new BufferedReader(new InputStreamReader(App.class.getResourceAsStream("archivos/servicios.txt")))){
            String cabezera=r.readLine();
            String linea=r.readLine();
            
            while(linea!=null){
                String[] datos=linea.split(",");
                listaServicios.add(new Servicio(datos[0],datos[1],Double.parseDouble(datos[2]),Double.parseDouble(datos[3])));
                linea=r.readLine();
            }
        }catch(IOException e){
            e.printStackTrace();
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

    public String toString(){
        return nombre;
    }

}
