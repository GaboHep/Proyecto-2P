package com.mycompany.proyecto2p;

public class Dinero {
    private static double presupuesto;

    public Dinero(double presupuesto) {
        this.presupuesto = presupuesto;
    }
    
    public void aumentarPresupuesto(double valorAAnadir) {
        this.presupuesto += valorAAnadir;
    }
    
    public void reducirPresupuesto(double valorAQuitar) {
       this.presupuesto -= valorAQuitar;
    }

    public double getPresupuesto() {
        return presupuesto;
    }
}
