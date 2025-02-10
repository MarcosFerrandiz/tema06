package com.marcosferrandiz.tema06.pilaArrays.Ejercicio7;

public class Medicos {
    private String nombre;
    private String numeroColegiado;

    public Medicos(String nombre, String numeroColegiado) {
        this.nombre = nombre;
        this.numeroColegiado = numeroColegiado;
    }

    public String getNumeroColegiado() {
        return numeroColegiado;
    }

    public void setNumeroColegiado(String numeroColegiado) {
        this.numeroColegiado = numeroColegiado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre + " (Colegiado: " + numeroColegiado + ")";
    }
}
