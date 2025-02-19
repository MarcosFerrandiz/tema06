package com.marcosferrandiz.tema06.Ejercicio6;

import com.marcosferrandiz.tema06.libreria.solicitarCosas;

public class Ejercicio6 {
    private static Bicicleta[] bicicletas;
    public static void main(String[] args) {
        int deci = 0;
        do {
            menuPrincipal();
            deci = solicitarCosas.solicitarInt(" ",0);

            switch (deci){
                case 1:
                case 2:
                case 3:
                case 4:
                case 0: break;
                default:
            }
        }while (deci == 0);
    }

    public static void menuPrincipal(){
        System.out.println("*************************");
        System.out.println("** GESTIÓN DE BICICLETAS **");
        System.out.println("*************************");
        System.out.println("1.- Añadir bicicleta ...");
        System.out.println("2.- Vender bicicleta ...");
        System.out.println("3.- Consultar bicicleta ...");
        System.out.println("4.- Mostrar stock");
        System.out.println("------------------------------------");
        System.out.println("0.- Salir");
    }
}
