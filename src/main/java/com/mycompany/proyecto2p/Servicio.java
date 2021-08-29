package com.mycompany.proyecto2p;

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
    
    public static void llenarServicios() {
        
        Servicio escuela = new Servicio("Escuela", "/servicios/schools/school.png", 1500.0, 150);
        Servicio calleHorizontal = new Servicio("Calle Horizontal", "/servicios/street1.png", 50.0, 10.0);
        Servicio calleVertical = new Servicio("Calle Vertical", "/servicios/streetvertical.png", 50.0, 10.0);
        Servicio parque = new Servicio("Parque", "/servicios/park/park1.png", 1500.0, 150.0);
        Servicio electricidad = new Servicio("Electricidad", "/servicios/electricity/electricity.png", 500.0, 200.0);
        Servicio agua = new Servicio("Agua", "/servicios/water/water.png", 500.0, 150.0);
        Servicio policia = new Servicio("Policia", "/servicios/hospital.png", 700.0, 700.0);
        Servicio hospital = new Servicio("Hospital", "/servicios/police.png", 1400.0, 800.0);
        
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
