package com.marcosferrandiz.tema06.Ejercicio6;

import java.util.GregorianCalendar;

public class Bicicleta {
    private final String referencia;
    private final String marca;
    private final String modelo;
    private final double peso;
    private final double tamanyo;
    private final boolean motor;
    private final String fechFab;
    private final double precio;
    private  int stock;

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getReferencia() {
        return referencia;
    }

    public Bicicleta(String referencia, String marca, String modelo, double peso, double tamanyo, boolean motor, String fechFab, double precio, int stock) {
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

    @Override
    public String toString() {
        return "Bicicleta{" + "referencia='" + referencia + '\'' + ", marca='" + marca + '\'' + ", modelo='" + modelo + '\'' + ", peso=" + peso + ", tamanyo=" + tamanyo + ", motor=" + motor + ", fechFab=" + fechFab + ", precio=" + precio + ", stock=" + stock + '}';
    }

    private String formatFecha(GregorianCalendar fecha){
        return String.format("%04d-%02d-%02d",fecha.get(GregorianCalendar.YEAR), fecha.get(GregorianCalendar.MONTH),fecha.get(GregorianCalendar.DAY_OF_MONTH));
    }
}
