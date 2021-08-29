/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2p;

import static com.mycompany.proyecto2p.Configuracion.PRESUPUESTO_INICIAL_DIFICIL;
import static com.mycompany.proyecto2p.Configuracion.PRESUPUESTO_INICIAL_FACIL;
import static com.mycompany.proyecto2p.Configuracion.PRESUPUESTO_INICIAL_MEDIO;

/**
 *
 * @author Howard Lima
 */
public class Dinero {
    private double presupuesto;
    private double impuestoRenta;
    private double impuestoContaminacion;
//Selección de dinero en función de su dificultad
    
    public Dinero(double presupuesto){
        if(){
            this.presupuesto = PRESUPUESTO_INICIAL_FACIL;
        }
        else if(){
            this.presupuesto = PRESUPUESTO_INICIAL_MEDIO;
    }
        else(){
            this.presupuesto = PRESUPUESTO_INICIAL_DIFICIL;
    }
    }
    public double gananciaComercial(double presupuesto,){
        
    } 
            
            
    public double pagoImpuestos(double presupuesto,int ALUMBRADO_IMPUESTO, int AGUA_IMPUESTO, int SUELO_IMPUESTO){
        presupuesto-=(ALUMBRADO_IMPUESTO+AGUA_IMPUESTO+SUELO_IMPUESTO);
        return presupuesto;
    }
    public double pagoZonaComercial(double presupuesto,double RENTA_IMPUESTO){
        presupuesto-=(presupuesto*RENTA_IMPUESTO);
        return presupuesto;
    }
    public double pagoZonaIndustrial(double presupuesto,int CONTAMINACION_IMPUESTO){
        presupuesto-=CONTAMINACION_IMPUESTO;
        return presupuesto;
    }
    }
