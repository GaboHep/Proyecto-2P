package com.mycompany.proyecto2p;

import java.io.BufferedReader;
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
                String nombre = lineaSeparada[0].strip();
                String ruta = lineaSeparada[1].strip();
                double precioConstruccion = Double.parseDouble(lineaSeparada[2]);
                double precioMensual = Double.parseDouble(lineaSeparada[3]);

                listaServicios.add(new Servicio(nombre, ruta, precioConstruccion, precioMensual));

            }

            buffer.close();

        }

        catch (Exception e) {

        }

        finally {

            Servicio escuela = new Servicio("Escuela", "/servicios/schools/school.png", 1500, 150);
            Servicio calleHorizontal = new Servicio("CalleHorizontal", "/servicios/street1.png", 1500, 150);
            Servicio calleVertical = new Servicio("Calle Vertical","/servicios/streetvertical.png",50,10);
            Servicio parque = new Servicio("Parque","/servicios/park/park1.png",1500,150);
            Servicio electricidad = new Servicio("Electricidad","/servicios/electricity/electricity.png",500,200);
            Servicio agua = new Servicio("Agua","/servicios/water/water.png",500,150);
            Servicio policia = new Servicio("Policia","/servicios/hospital.png",700,700);
            Servicio hospital = new Servicio("Hospital","/servicios/police.png",1400,800);

            listaServicios.add(escuela);
            listaServicios.add(calleHorizontal);
            listaServicios.add(calleVertical);
            listaServicios.add(parque);
            listaServicios.add(electricidad);
            listaServicios.add(agua);
            listaServicios.add(policia);
            listaServicios.add(hospital);
            
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
