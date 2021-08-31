package com.mycompany.proyecto2p;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;

public class Ciudad implements Serializable {
    public static Ciudad ciudadUtilizada;
    private String nombre;
    private String nombreAlcalde;
    private LocalDate fecha = LocalDate.now();
    private double presupuesto;
    private ArrayList<Servicio> servicios=new ArrayList<>();
    public Object [][] edificios2d; //Lista de 2 dimensiones que posee todos los edificios relacionados a la ciudad

    public Ciudad(String nombre, String nombreAlcalde, double presupuesto) {
        this.nombre = nombre;
        this.nombreAlcalde = nombreAlcalde;
        this.presupuesto = presupuesto;
        this.edificios2d=new Object[Configuracion.FILAS][Configuracion.COLUMNAS];
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
    
    //Para guardar la partida
    public static void serializarPeliculas(){
        try(ObjectOutputStream s=new ObjectOutputStream(new FileOutputStream("ciudad.bin"))){
            s.writeObject(ciudadUtilizada);
        }catch(IOException ex){
            ex.printStackTrace();
            
        }
        
    }
    //Para cargar la partida.
    public static void deserializarPeliculas(){
        try(ObjectInputStream s=new ObjectInputStream(new FileInputStream("ciudad.bin"))){
            ciudadUtilizada=(Ciudad)s.readObject();
            
        }catch(FileNotFoundException e){
            Alert a= new Alert(AlertType.INFORMATION);
            a.setTitle("No se encontro la partida guardada");
            a.setContentText("La partida que estas buscando no existe");
            
        }catch(IOException ex){
            ex.printStackTrace();
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
    }
    
    
}
