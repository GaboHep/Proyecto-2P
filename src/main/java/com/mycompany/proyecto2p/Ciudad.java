package com.mycompany.proyecto2p;

import java.util.ArrayList;

public class Ciudad {
    private String nombre;
    private String nombreAlcalde;
    private Tiempo tiempo;
    private double presupuesto;
    private ArrayList <Servicio> servicios=new ArrayList<>();

    public Ciudad(String nombre, String nombreAlcalde, double presupuesto) {
        this.nombre = nombre;
        this.nombreAlcalde = nombreAlcalde;
        this.presupuesto = presupuesto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNombreAlcalde(String nombreAlcalde) {
        this.nombreAlcalde = nombreAlcalde;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    public void setTiempo(Tiempo tiempo) {
        this.tiempo = tiempo;
    }
    
    
    //Metodos que sirven para cuando se gaste o gane dinero en la ciudad.
    public void disminuirPresupuesto(int cantidad){
        presupuesto=presupuesto-cantidad;
    }
    public void aumentarPresupuesto(int cantidad){
        presupuesto=presupuesto+cantidad;
    }
}
