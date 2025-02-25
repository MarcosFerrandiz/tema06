package com.marcosferrandiz.tema06.Ejercicio3;

import com.marcosferrandiz.tema06.libreria.solicitarCosas;

import java.time.LocalDate;

public class Ejercicio3 {

    private static Centro centro = new Centro();

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
            seleccion = solicitarCosas.solicitarEntero("Seleccione la opción deseada",0,3);

            if (seleccion <0 || seleccion >3){
                System.err.println("El valor introducido no es valido");
            }
            switch (seleccion){
                case 1 -> crearAlumno();
                //case 2 ->;
                //case 3 -> ;
                //default -> /*Hola ;
            }
        }while (seleccion != 0);


    }

    public static void crearAlumno(){
        int nia;
        String nombre;
        String apellido;
        LocalDate fechaNac;
        String grupo;
        int tel;
        boolean crearAlumnoVerificacion = false;
        do {
            nia = solicitarCosas.solicitarInt("Introduzca el NIA del alumno a crear: ",0);
            nombre = solicitarCosas.solicitarStringSinLimite("Introduzca el nombre del alumno: ");
            apellido = solicitarCosas.solicitarStringSinLimite("Introduzca el apellido del alumno: ");
            fechaNac = solicitarCosas.solicitarFecha("Introduzca la fecha de nacimiento", "dd/MM/yyyy");
            grupo = solicitarCosas.solicitarStringSinLimite("Introduzca el grupo al que pertenece: ");
            tel = solicitarCosas.solicitarInt("Introduzca el numero de telefono: ",0);
            crearAlumnoVerificacion = centro.crearAlumno(nia,nombre,apellido,fechaNac,grupo,tel);
            System.out.println(crearAlumnoVerificacion);
            if (!crearAlumnoVerificacion){
                System.err.println("Error, el NIA ese ya esta seleccionado en otro alumno");
            }else {
                System.out.println("Se ha creado correctamente");
            }
        }while (!crearAlumnoVerificacion);
    }

    public static void main(String[] args) {
        crearAlumno();
        System.out.println(centro.toString());
        crearAlumno();
        System.out.println(centro.toString());
    }
}
