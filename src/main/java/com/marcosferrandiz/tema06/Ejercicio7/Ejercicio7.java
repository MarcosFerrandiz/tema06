package com.marcosferrandiz.tema06.Ejercicio7;

import com.marcosferrandiz.tema06.libreria.solicitarCosas;
import com.marcosferrandiz.tema06.libreria.toStrings;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Ejercicio7 {
    private static CentroSalud centroSalud = new CentroSalud();
    public static void mostrarMenuPrincipal(){
        int deci;
        do {

            System.out.println("********************");
            System.out.println("** URGENCIAS **");
            System.out.println("********************");
            System.out.println("1. Nuevo paciente ...");
            System.out.println("2. Atender paciente ...");
            System.out.println("3. Consultas ...");
            System.out.println("4. Alta médica ...");
            System.out.println("-----------------------------");
            System.out.println("0. Salir");

            deci = solicitarCosas.solicitarEntero("¿Que desea hacer?", 0, 5);

            switch (deci) {
                case 0 -> {
                    System.out.println("Saliendo...");
                    return;
                }
                case 1 -> nuevoPaciente();
                case 2-> atenderPaciente();
                case 5 -> System.out.println(centroSalud.toString());

            }
        }while (deci != 0);
    }

    public static void nuevoPaciente(){
        int sip = solicitarCosas.solicitarInt("Introduzca el número SIP: ",0);
        if (comprobarSipSiExiste(sip)){
            System.err.println("Ese SIP ya esta asignado a otro Paciente");
            return;
        }
        String nombre = solicitarCosas.solicitarStringSinLimite("Introduzca el nombre del paciente: ");
        int edad = solicitarCosas.solicitarEntero("Introduzca la edad del paciente: ",0,130);
        char generoDecision = solicitarCosas.solicitarCaracter("Introduzca el genero del paciente: ( H | M)");
        Pacientes.Sexo genero = Pacientes.Sexo.TROMPO_KING_COBRA;
        if (generoDecision == 'H' || generoDecision == 'h' || generoDecision == 'M' || generoDecision == 'm'){
            genero = generoDecision == 'h' || generoDecision == 'H' ? Pacientes.Sexo.HOMBRE : Pacientes.Sexo.MUJER;
        }
        else {
            System.err.println("Ese genero no existe y no esta en la lista");
        }
        LocalDateTime fechHoraLlegada = LocalDateTime.now();
        String sintomas = solicitarCosas.solicitarStringSinLimite("Introduzca los sintomas del paciente: ");

        centroSalud.crearPaciente(sip,nombre,genero,edad,fechHoraLlegada,sintomas);
    }

    public static boolean comprobarSipSiExiste(int sip){
        for (int i = 0; i < centroSalud.getCantidadPacientes() ; i++) {
            if (centroSalud.getPacientes()[i].getSip() == sip){
                return true;
            }
        }
        return false;
    }

    public static void atenderPaciente(){
        int sip = solicitarCosas.solicitarInt("Indique el SIP del paciente a atender: ",0);
        if (!comprobarSipSiExiste(sip)){
            System.err.println("El sip no existe");
            return;
        }
        double[] preRev = new double[4];
        double temp = solicitarCosas.solicitarDoubleConMinimo("Introduzca la temperatura: ",0);
        double ppm = solicitarCosas.solicitarDoubleConMinimo("Introduzca las pulsaciones por minuto (ppm): ",0);
        double tenSis = solicitarCosas.solicitarDoubleConMinimo("Introduzca la tensión sistolica: ",0);
        double tenDias = solicitarCosas.solicitarDoubleConMinimo("Introduzca la tensión diastólica: ",0);
        preRev[0] = temp;
        preRev[1] = ppm;
        preRev[2] = tenSis;
        preRev[3] = tenDias;

        if (centroSalud.atenderPaciente(sip, centroSalud,preRev)){
            System.out.println("Atendiendo paciente...");
        }
        else {
            System.err.println("Error, el paciente a se está atendiendo");
        }
    }




    public static void main(String[] args) {
        mostrarMenuPrincipal();
    }
}
