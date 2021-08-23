package com.mycompany.proyecto2p;

public class Ciudad {
    
    String NombreCiudad;
    String NombreAlcalde;
    Tiempo tiempo = new Tiempo();
    Dinero dinero;
    
    public Ciudad(String NombreCiudad, String NombreAlcalde, double presupuestoInicial) {
        this.NombreCiudad = NombreCiudad;
        this.NombreAlcalde = NombreAlcalde;
        this.dinero = new Dinero(presupuestoInicial);
    }

    public Tiempo getTiempo() {
        return tiempo;
    }

    public Dinero getDinero() {
        return dinero;
    }
}
