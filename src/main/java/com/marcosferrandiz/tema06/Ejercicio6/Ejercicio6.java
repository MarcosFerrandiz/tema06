package com.marcosferrandiz.tema06.Ejercicio6;

import com.marcosferrandiz.tema06.libreria.solicitarCosas;

import java.util.GregorianCalendar;

public class Ejercicio6 {
    public static void main(String[] args) {
        Tienda tienda = new Tienda();
        tienda.inicializarInventario();
        tienda.mostrarMenu();
    }
}
