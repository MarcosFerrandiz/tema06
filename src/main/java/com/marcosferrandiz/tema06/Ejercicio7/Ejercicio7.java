package com.marcosferrandiz.tema06.Ejercicio7;

import com.marcosferrandiz.tema06.libreria.solicitarCosas;
import com.marcosferrandiz.tema06.libreria.toStrings;

public class Ejercicio7 {
    private static CentroSalud centroSalud = new CentroSalud();
    public static void mostrarMenuPrincipal(){
        while (true) {
            System.out.println("********************");
            System.out.println("** URGENCIAS **");
            System.out.println("********************");
            System.out.println("1. Nuevo paciente ...");
            System.out.println("2. Atender paciente ...");
            System.out.println("3. Consultas ...");
            System.out.println("4. Alta médica ...");
            System.out.println("-----------------------------");
            System.out.println("0. Salir");

            int deci = solicitarCosas.solicitarEntero("¿Que desea hacer?", 0, 5);

            switch (deci) {
                case 0 -> {
                    System.out.println("Saliendo...");
                    return;
                }

            }
        }
    }

    public static void nuevoPaciente(){
        int sip = solicitarCosas.solicitarInt("Introduzca el número SIP: ",0);
        String nombre = solicitarCosas.solicitarStringSinLimite("Introduzca el nombre del paciente: ");

    }



    public static void main(String[] args) {
        System.out.println(toStrings.enumToString());
    }
}
