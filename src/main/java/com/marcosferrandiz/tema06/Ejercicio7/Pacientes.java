package com.marcosferrandiz.tema06.Ejercicio7;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Pacientes {
    public enum Sexo{
        HOMBRE, MUJER, TROMPO_KING_COBRA
    }
    private final int sip;
    private final String nombre;
    private final Sexo genero;
    private final LocalDate fechaNacimiento;

    public Pacientes(int sip, String nombre, Sexo genero, LocalDate fechaNacimiento) {
        this.sip = sip;
        this.nombre = nombre;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Pacientes{" +
                "sip=" + sip +
                ", nombre='" + nombre + '\'' +
                ", genero=" + genero +
                ", edad=" + (ChronoUnit.YEARS.between(fechaNacimiento,LocalDate.now())) +
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
