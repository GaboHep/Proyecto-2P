package com.mycompany.proyecto2p;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Tiempo {
    private LocalDate fecha = LocalDate.now();
    private DateTimeFormatter formato = DateTimeFormatter.ISO_DATE;
    
    public void siguienteDia() {
        fecha = fecha.plusDays(1);
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
