package com.marcosferrandiz.tema06.pilaArrays.Ejercicio7;

import java.time.LocalDateTime;

public class Paciente {
    private String nombre;
    private String sip;
    private LocalDateTime fech_lleg;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSip() {
        return sip;
    }

    public void setSip(String sip) {
        this.sip = sip;
    }

    public LocalDateTime getFech_lleg() {
        return fech_lleg;
    }

    public void setFech_lleg(LocalDateTime fech_lleg) {
        this.fech_lleg = fech_lleg;
    }

    public Paciente(String nombre, String sip, LocalDateTime fech_lleg) {
        this.nombre = nombre;
        this.sip = sip;
        this.fech_lleg = fech_lleg;
    }

    @Override
    public String toString() {
        return "Paciente{" + "nombre='" + nombre + '\'' + ", sip='" + sip + '\'' + ", fech_lleg=" + fech_lleg + '}';
    }
}
