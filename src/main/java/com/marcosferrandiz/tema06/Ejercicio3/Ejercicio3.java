package com.marcosferrandiz.tema06.Ejercicio3;

import java.util.Scanner;

public class Ejercicio3 {
    private Scanner input = new Scanner(System.in);
    public static void principalMenu(){
        System.out.println("*********************");
        System.out.println("** GESTIÓN ALUMNOS **");
        System.out.println("*********************");
        System.out.println("1. Nuevo alumno …");
        System.out.println("2. Baja de alumno …");
        System.out.println("3. Consultas …");
        System.out.println("------------------------------");
        System.out.println("0. Salir");
    }
    public static void consultasMenu(){
        System.out.println("***************");
        System.out.println("** CONSULTAS **");
        System.out.println("***************");
        System.out.println("1. Por grupo …");
        System.out.println("2. Por edad …");
        System.out.println("3. Por NIA …");
        System.out.println("4. Por apellidos …");
        System.out.println("------------------------------");
        System.out.println("0. Volver al menú principal");
    }

    public static void main(String[] args) {
        principalMenu();
    }
}
