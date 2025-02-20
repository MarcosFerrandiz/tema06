package com.marcosferrandiz.tema06.Ejercicio6;

import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Bicicleta {
    private String referencia;
    private String marca;
    private String modelo;
    private double peso;
    private int tamanoRuedas;
    private boolean tieneMotor;
    private LocalDate fechaFabricacion;
    private double precio;
    private int existencias;

    public Bicicleta(String referencia, String marca, String modelo, double peso, int tamanoRuedas, boolean tieneMotor, LocalDate fechaFabricacion, double precio, int existencias) {
        this.referencia = referencia;
        this.marca = marca;
        this.modelo = modelo;
        this.peso = peso;
        this.tamanoRuedas = tamanoRuedas;
        this.tieneMotor = tieneMotor;
        this.fechaFabricacion = fechaFabricacion;
        this.precio = precio;
        this.existencias = existencias;
    }

    public String getReferencia() {
        return referencia;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    @Override
    public String toString() {
        return "Referencia: " + referencia + "\n" +
                "Marca: " + marca + "\n" +
                "Modelo: " + modelo + "\n" +
                "Peso: " + peso + "kg\n" +
                "Tamaño Ruedas: " + tamanoRuedas + " pulgadas\n" +
                "Motor: " + (tieneMotor ? "Sí" : "No") + "\n" +
                "Fecha Fabricación: " + fechaFabricacion + "\n" +
                "Precio: " + precio + "€\n" +
                "Stock: " + existencias;
    }
}
