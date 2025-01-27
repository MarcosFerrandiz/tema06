package com.marcosferrandiz.tema06.Ejercicio3;

public class alumno {
    private int nia;
    private String nombre;
    private String apellidos;
    private String nacimiento;
    private String grupo;
    private int tel;

    public alumno(int nia, String nombre, String apellidos, String nacimiento, String grupo, int tel) {
        this.nia = nia;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacimiento = nacimiento;
        this.grupo = grupo;
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "alumno{" + "nia=" + nia + ", nombre='" + nombre + '\'' + ", apellidos='" + apellidos + '\'' + ", nacimiento='" + nacimiento + '\'' + ", grupo='" + grupo + '\'' + ", tel=" + tel + '}';
    }
}
