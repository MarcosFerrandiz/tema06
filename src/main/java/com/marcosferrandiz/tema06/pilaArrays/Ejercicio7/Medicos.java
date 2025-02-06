package com.marcosferrandiz.tema06.pilaArrays.Ejercicio7;

public class Medicos {
    private String nombre;
    private int num_cole;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNum_cole() {
        return num_cole;
    }

    public void setNum_cole(int num_cole) {
        this.num_cole = num_cole;
    }

    public Medicos(String nombre, int num_cole) {
        this.nombre = nombre;
        this.num_cole = num_cole;
    }

    @Override
    public String toString() {
        return "Medicos{" + "nombre='" + nombre + '\'' + ", num_cole=" + num_cole + '}';
    }
}
