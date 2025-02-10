package com.marcosferrandiz.tema06.pilaArrays.Ejercicio7;

import java.time.LocalDateTime;

public class Paciente {
    private String nombre;
    private String sip;
    private LocalDateTime fechaHoraIngreso;

    public Paciente(String nombre, String sip) {
        this.nombre = nombre;
        this.sip = sip;
        this.fechaHoraIngreso = LocalDateTime.now();
    }

    public String getNombre() {
        return nombre;
    }

    public String getSip() {
        return sip;
    }

    public LocalDateTime getFechaHoraIngreso() {
        return fechaHoraIngreso;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSip(String sip) {
        this.sip = sip;
    }

    public void setFechaHoraIngreso(LocalDateTime fechaHoraIngreso) {
        this.fechaHoraIngreso = fechaHoraIngreso;
    }

    @Override
    public String toString() {
        return nombre + " (SIP: " + sip + ") - Llegada: " + fechaHoraIngreso;
    }
}
