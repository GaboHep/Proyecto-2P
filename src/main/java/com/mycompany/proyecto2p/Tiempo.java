package com.mycompany.proyecto2p;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.application.Platform;
import javafx.scene.control.Label;

public class Tiempo {
    private LocalDate fecha = LocalDate.now();
    private DateTimeFormatter formato = DateTimeFormatter.ISO_DATE;
    
    public void siguienteDia() {
        fecha = fecha.plusDays(1);
    }

    public static void transcursoDelTiempo(Label lblTiempo, Tiempo tiempo) {
        
        while (true) {
            try {
                Platform.runLater(() -> lblTiempo.setText(tiempo.getFecha().toString()));
                tiempo.siguienteDia();
                Thread.sleep(5000);
            }
            catch(InterruptedException ex) {
            }
        }
    }    
    
    public LocalDate getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        String resultado = fecha.format(formato);
        return resultado;
    }
}
