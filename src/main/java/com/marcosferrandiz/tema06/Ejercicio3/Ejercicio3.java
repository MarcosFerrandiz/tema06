package com.marcosferrandiz.tema06.Ejercicio3;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio3 {

    public static final int MAX_ALUMNOS = 99;
    public static Alumno[] alumnos = new Alumno[MAX_ALUMNOS];
    private static Scanner input = new Scanner(System.in);

    public static void principalMenu(){
        int seleccion = 0;
        do {
            System.out.println("*********************");
            System.out.println("** GESTIÓN ALUMNOS **");
            System.out.println("*********************");
            System.out.println("1. Nuevo Alumno …");
            System.out.println("2. Baja de Alumno …");
            System.out.println("3. Consultas …");
            System.out.println("------------------------------");
            System.out.println("0. Salir");
            seleccion = Integer.parseInt(input.nextLine());

            if (seleccion <0 && seleccion >3){
                System.err.println("El valor introducido no es valido");
            }
            switch (seleccion){
                //case 1 -> ;
                //case 2 ->;
                //case 3 -> ;
                //default -> /*Hola*/ ;
            }
        }while (seleccion != 0);


    }



    public static void main(String[] args) {

        principalMenu();
    }
}
