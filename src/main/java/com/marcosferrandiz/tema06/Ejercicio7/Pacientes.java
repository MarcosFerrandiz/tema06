package com.marcosferrandiz.tema06.Ejercicio7;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Pacientes {
    private enum Sexo{
        V, M
    }
    private final int sip;
    private final String nombre;
    private final Sexo genero;
    private final int edad;
    private LocalDateTime fechHoraLlegada;
    private final String sintomas;
    private final double[] preRev;

    public Pacientes(int sip, String nombre, Sexo genero, int edad, LocalDateTime fechHoraLlegada, String sintomas) {
        this.sip = sip;
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.fechHoraLlegada = LocalDateTime.now();
        this.sintomas = sintomas;
        this.preRev = new double[4];
    }

    public double[] getPreRev() {
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
                "sip=" + sip +
                ", nombre='" + nombre + '\'' +
                ", genero=" + genero +
                ", edad=" + edad +
                ", fechHoraLlegada=" + fechHoraLlegada +
                ", sintomas='" + sintomas + '\'' +
                ", preRev=" + Arrays.toString(preRev) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pacientes pacientes = (Pacientes) o;
        return sip == pacientes.sip && edad == pacientes.edad && Objects.equals(nombre, pacientes.nombre) && genero == pacientes.genero && Objects.equals(fechHoraLlegada, pacientes.fechHoraLlegada) && Objects.equals(sintomas, pacientes.sintomas) && Objects.deepEquals(preRev, pacientes.preRev);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sip, nombre, genero, edad, fechHoraLlegada, sintomas, Arrays.hashCode(preRev));
    }
}
