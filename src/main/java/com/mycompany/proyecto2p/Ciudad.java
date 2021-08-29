package com.mycompany.proyecto2p;

import java.util.ArrayList;

public class Ciudad {
    private String nombre;
    private String nombreAlcalde;
    private String tiempo;
    private int presupuesto;
    private ArrayList <Servicio> servicios=new ArrayList<>();

    public Ciudad(String nombre, String nombreAlcalde, int presupuesto) {
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
    
    public void disminuirPresupuesto(int cantidad){
        presupuesto=presupuesto-cantidad;
    }
    
}
