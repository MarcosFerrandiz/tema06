package com.marcosferrandiz.tema06.Ejercicio7;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Pacientes {
    private final PreRev[] preRev;
    public enum Sexo{
        HOMBRE, MUJER, TROMPO_KING_COBRA
    }
    private final int sip;
    private final String nombre;
    private final Sexo genero;
    private final int edad;
    private LocalDateTime fechHoraLlegada;
    private final String sintomas;

    public Pacientes(String sintomas,LocalDateTime fechHoraLlegada, int edad, Sexo genero, String nombre, int sip, PreRev[] preRev) {
        this.sintomas = sintomas;
        this.fechHoraLlegada = fechHoraLlegada;
        this.edad = edad;
        this.genero = genero;
        this.nombre = nombre;
        this.sip = sip;
        this.preRev = preRev;
    }

    public PreRev[] getPreRev() {
        return preRev;
    }

    public int getSip() {
        return sip;
    }

    public String getNombre() {
        return nombre;
    }

    public Sexo getGenero() {
        return genero;
    }

    public int getEdad() {
        return edad;
    }

    public LocalDateTime getFechHoraLlegada() {
        return fechHoraLlegada;
    }

    public void setFechHoraLlegada(LocalDateTime fechHoraLlegada) {
        this.fechHoraLlegada = fechHoraLlegada;
    }

    public String getSintomas() {
        return sintomas;
    }


    @Override
    public String toString() {
        return "Pacientes{" +
                ", sip=" + sip +
                ", nombre='" + nombre + '\'' +
                ", genero=" + genero +
                ", edad=" + edad +
                ", fechHoraLlegada=" + fechHoraLlegada +
                ", sintomas='" + sintomas + '\'' +
                "preRev=" + Arrays.toString(preRev)+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pacientes pacientes = (Pacientes) o;
        return sip == pacientes.sip;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(sip);
    }
}
