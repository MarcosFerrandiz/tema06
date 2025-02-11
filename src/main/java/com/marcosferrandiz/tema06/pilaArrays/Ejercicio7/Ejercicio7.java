package com.marcosferrandiz.tema06.pilaArrays.Ejercicio7;

import java.util.Scanner;

public class Ejercicio7 {
    private static Hospital hospital = new Hospital();
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        int deci;

        do {
            mostrarMenu();
            deci = Integer.parseInt(input.nextLine());

            switch (deci){
                case 1:
                    anadirPaciente();
                    break;
                case 2:
                    atenderPaciente();
                    break;
                case 3:
                    hospital.mostrarColas();
                    break;
                case 4: {
                    System.out.println("Saliendo...");
                    break;
                }
                default: {
                    System.err.println("Opción no válida");
                }
            }

        }while (deci != 4);
    }

    public static void mostrarMenu(){
        System.out.println("=== HOSPITAL ===");
        System.out.println("1. Añadir paciente");
        System.out.println("2. Atender siguiente paciente");
        System.out.println("3. Mostrar estado de las colas");
        System.out.println("4. Salir");
        System.out.print("¿Que desea hacer?: ");
    }

    public static void anadirPaciente(){
        hospital.mostrarColas();
        System.out.println("En que sonsulta quieres añadir al paciente (1-5): ");
        int pacienteConsulta = Integer.parseInt(input.nextLine()) - 1;
        System.out.println("Introduzca el nombre del paciente: ");
        String pacienteNombre = input.nextLine();
        System.out.println("Introduzca el SIP del paciente: ");
        String pacienteSip = input.nextLine();
        Paciente nuevoPaciente = new Paciente(pacienteNombre,pacienteSip);
        hospital.getConsultas()[pacienteConsulta].anadirPaciente(nuevoPaciente);
        System.out.println("Paciente añadido en la consulta "+ (pacienteConsulta + 1));
    }

    public static void atenderPaciente(){
        hospital.mostrarColas();
        System.out.println("Eliga la consulta que quiera para atender al primer paciente (1-5): ");
        int consultaAtender = Integer.parseInt(input.nextLine())-1;
        Paciente pacienteAtendido = hospital.getConsultas()[consultaAtender].atenderPaciente();

        if (pacienteAtendido != null){
            System.out.println("Has atendido al paciente "+ pacienteAtendido);
        }
        else {
            System.out.println("En la consulta "+ consultaAtender+" no hay pacientes que atender");
        }
        System.out.println(hospital.getConsultas()[consultaAtender]);
    }
}
