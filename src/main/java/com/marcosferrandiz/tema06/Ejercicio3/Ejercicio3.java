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
                case 1 -> nuevoAlumno();
                //case 2 ->;
                case 3 -> consultasMenu();
                //default -> /*Hola*/ ;
            }
        }while (seleccion != 0);


    }

    public static void nuevoAlumno(){
        boolean check = false;
        int nia;
        do {
            System.out.println("Indique el NIA del alumno");
            nia = Integer.parseInt(input.nextLine());
            for (int i = 0; i < alumnos.length ; i++) {
                if (alumnos[i].getNia() == nia){
                    System.err.println("Ese NIA ya existe");
                    check = false;
                } else {
                    check = true;
                }
            }
        }while (!check);
        System.out.println("Indique el nombre del Alumno");
        String nombre = input.nextLine();

        System.out.println("Indique el apellido del Alumno");
        String apellido = input.nextLine();

        System.out.println("Fecha de nacimiento");
        String fecha = input.nextLine();

        System.out.println("Grupo");
        String grupo = input.nextLine();

        System.out.println("Telefono");
        int telefono = Integer.parseInt(input.nextLine());
        for (int i = 0; i < alumnos.length ; i++) {
            alumnos[i] = new Alumno(nia,nombre,apellido,fecha,grupo,telefono);
        }
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
