package com.marcosferrandiz.tema06.Ejercicio3;

import java.util.Objects;

public class Alumno {
    private final int nia;
    private final String nombre;
    private final String apellidos;
    private final String nacimiento;
    private final String grupo;
    private final int tel;

    public Alumno(int nia, String nombre, String apellidos, String nacimiento, String grupo, int tel) {
        this.nia = nia;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacimiento = nacimiento;
        this.grupo = grupo;
        this.tel = tel;
    }

    public int getNia() {
        return nia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public String getGrupo() {
        return grupo;
    }

    public int getTel() {
        return tel;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nia=" + nia + ", nombre='" + nombre + '\'' + ", apellidos='" + apellidos + '\'' + ", nacimiento='" + nacimiento + '\'' + ", grupo='" + grupo + '\'' + ", tel=" + tel + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return nia == alumno.nia;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nia);
    }
}
