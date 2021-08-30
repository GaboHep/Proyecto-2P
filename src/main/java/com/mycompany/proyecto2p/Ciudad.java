package com.mycompany.proyecto2p;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.scene.control.Label;

public class Ciudad {
    private String nombre;
    private String nombreAlcalde;
    private LocalDate fecha = LocalDate.now();
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

    public LocalDate getFecha() {
        return fecha;
    }
    
    
    //Metodos que sirven para cuando se gaste o gane dinero en la ciudad.
    public void disminuirPresupuesto(int cantidad){
        presupuesto=presupuesto-cantidad;
    }
    public void aumentarPresupuesto(int cantidad){
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
    
    public void transcursoDelTiempo(Label lblTiempo) {

        while (true) {
            try {
                Platform.runLater(() -> lblTiempo.setText(fechaToString()));
                siguienteDia();
                Thread.sleep(Configuracion.DURACION_DIA_SEGUNDOS * 1000);
            }
            catch(InterruptedException ex) {
            }
        }
    
    }
}
