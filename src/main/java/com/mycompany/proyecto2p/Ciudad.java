package com.mycompany.proyecto2p;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
import javafx.scene.control.Label;

public class Ciudad {
    public static Ciudad ciudadUtilizada;
    private String nombre;
    private String nombreAlcalde;
    private LocalDate fecha = LocalDate.now();
    private double presupuesto;
    private Servicio [][] servicios=new Servicio[8][8];

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

    public LocalDate getFecha() {
        return fecha;
    }
    
    
    //Metodos que sirven para cuando se gaste o gane dinero en la ciudad.
    public void disminuirPresupuesto(double cantidad){
        presupuesto=presupuesto-cantidad;
    }
    public void aumentarPresupuesto(double cantidad){
        presupuesto=presupuesto+cantidad;
    }
    
    public String fechaToString() {
        
        DateTimeFormatter formato = DateTimeFormatter.ISO_DATE;
        
        String resultado = fecha.format(formato);
        
        return resultado;
        
    }
    
    
    public void siguienteDia() {
        fecha = fecha.plusDays(1);
    }
    

    public String getNombre() {
        return nombre;
    }

    public String getNombreAlcalde() {
        return nombreAlcalde;
    }

    public double getPresupuesto() {
        return presupuesto;
    }
    
    
}
