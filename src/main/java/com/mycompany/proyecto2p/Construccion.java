/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2p;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author ggabo
 */
public class Construccion {
    public static ArrayList<Construccion> Construcciones=new ArrayList<>();
    private String nombre;
    private int valorAP;
    private int valorAgua;
    private int impuestoSM;
    private String ruta;
    private String ruta2;

    public Construccion(String nombre, int valorAP, int valorAgua, int impuestoSM, String ruta, String ruta2) {
        this.nombre = nombre;
        this.valorAP = valorAP;
        this.valorAgua = valorAgua;
        this.impuestoSM = impuestoSM;
        this.ruta = ruta;
        this.ruta2 = ruta2;
    }
    
    public static void llenarConstrucciones(){
        try(BufferedReader r=new BufferedReader(new InputStreamReader(App.class.getResourceAsStream("archivos/tipoConstruccion.txt")))){
            String cabezera=r.readLine();
            String linea=r.readLine();
            
            while(linea!=null){
                String[] datos=linea.split(";");
                Construcciones.add(new Construccion(datos[0],Integer.parseInt(datos[1]),Integer.parseInt(datos[2]),Integer.parseInt(datos[3]),datos[4],datos[5]));
                linea=r.readLine();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public int valorAPagar(){
        return valorAP+valorAgua+impuestoSM;
    }
    
    
}
