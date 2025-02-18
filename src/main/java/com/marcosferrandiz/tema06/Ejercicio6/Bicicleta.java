package com.marcosferrandiz.tema06.Ejercicio6;

import java.util.GregorianCalendar;

public class Bicicleta {
    private final String referencia;
    private final String marca;
    private final String modelo;
    private final float peso;
    private final float tamanyo;
    private final boolean motor;
    private final GregorianCalendar fechFab;
    private final double precio;
    private final int stock;

    public Bicicleta(String referencia, String marca, String modelo, float peso, float tamanyo, boolean motor, GregorianCalendar fechFab, double precio, int stock) {
        this.referencia = referencia;
        this.marca = marca;
        this.modelo = modelo;
        this.peso = peso;
        this.tamanyo = tamanyo;
        this.motor = motor;
        this.fechFab = fechFab;
        this.precio = precio;
        this.stock = stock;
    }


}
