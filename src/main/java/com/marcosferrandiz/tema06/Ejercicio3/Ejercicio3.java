package com.marcosferrandiz.tema06.Ejercicio3;

import com.marcosferrandiz.tema06.libreria.solicitarCosas;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;

import com.github.javafaker.Faker;



public class Ejercicio3 {

    private static Centro centro = new Centro();

    /**
     * Metodo que genera el menu principal
     */
    public static void principalMenu(){
        int seleccion = 0;
        do {
            System.out.println("*********************");
            System.out.println("** GESTIÓN ALUMNOS **");
            System.out.println("*********************");
            System.out.println("1. Nuevo Alumno …");
            System.out.println("2. Baja de Alumno …");
            System.out.println("3. Consultas …");
            System.out.println("4. Generar con Faker …");
            System.out.println("5. Ver …");
            System.out.println("------------------------------");
            System.out.println("0. Salir");
            seleccion = solicitarCosas.solicitarEntero("Seleccione la opción deseada",0,5);

            switch (seleccion){
                case 0 -> System.out.println("Saliendo...");
                case 1 -> crearAlumno();
                case 2 -> darDeBajaAlumno();
                case 3 -> consultasMenu();
                case 4 -> generarAlumnosConFaker(5);
                case 5 -> System.out.println(centro);
                default -> System.err.println("Opcion no valida");
            }
        }while (seleccion != 0);
    }

    public static void consultasMenu(){
        int seleccion = 0;
        do {
            System.out.println("***************");
            System.out.println("** CONSULTAS **");
            System.out.println("***************");
            System.out.println("1. Por grupo ...");
            System.out.println("2. Por edad ...");
            System.out.println("3. Por nia ...");
            System.out.println("4. Por apellidos ...");
            System.out.println("--------------------");
            System.out.println("0. Volver al menú principal");
            seleccion = solicitarCosas.solicitarEntero("Seleccione la opción deseada",0,4);
            if (seleccion <0 || seleccion >4){
                System.err.println("El valor introducido no es valido");
            }

            switch (seleccion){
                case 0 -> principalMenu();
                case 1 -> mostrarAlumnosDeGrupo();
                case 2 -> mostrarAlumnosPorEdad();
                case 3 -> mostrarAlumnosPorNia();
                case 4 -> mostrarAlumnosPorApellidos();
            }

        }while (seleccion != 0);

    }

    public static void generarAlumnosConFaker(int cantidad){
        Faker faker = new Faker();
        for (int i = 0; i <= cantidad ; i++) {
            int nia = faker.number().numberBetween(10000000,99999999);
            String nombre = faker.name().name();
            String apellido = faker.name().lastName();

            //Aqui he tirado de chatGPT porque no tenia ni idea de como funciona faker ni como pasar un date que es lo que te da a un LocalDate
            LocalDate hoy = LocalDate.now();
            LocalDate hace100Anios = hoy.minusYears(100);
            Date fechNac = faker.date().between(Date.from(hace100Anios.atStartOfDay(ZoneId.systemDefault()).toInstant()), Date.from(hoy.atStartOfDay(ZoneId.systemDefault()).toInstant()));
            LocalDate nacimiento = fechNac.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            //--------------------------------------------------------------------------------------------------

            String grupo = faker.options().option(new String[]{"1DAM","2DAM","1DAW","2DAW"});
            int telEnInt = faker.number().numberBetween(10000000,99999999);

            centro.crearAlumno(nia,nombre,apellido,nacimiento,grupo,telEnInt);
        }
    }

    /**
     * Metodo que da de alta a un alumno
     */
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
                System.err.println("Error, el NIA ese ya esta seleccionado en otro alumno o esta lleno el array de alumnos");
            }else {
                System.out.println("Se ha creado correctamente");
            }
        }while (!crearAlumnoVerificacion);
    }


    /**
     * Metodo que da de baja a un alumno
     */
    public static void darDeBajaAlumno(){
        char deci;
        int nia = solicitarCosas.solicitarInt("Introduzca el NIA del alumno a dar de baja: ",0);
        boolean niaVerificado = centro.buscarNia(nia);
        if (niaVerificado){
            deci = solicitarCosas.solicitarCaracter("Esta seguro de que desea eliminar al alumno con el NIA "+ nia+" ( S | N )");
            if (deci == 'S' || deci == 's'){
                centro.bajaAlumno(nia);
                System.out.println("Se ha dado de baja de forma correcta");
            }
            else {
                System.out.println("Si es que hay que pensarselo mejor hombre");
            }
        }
        else {
            System.err.println("Ese nia no existe, confirme que lo ha escrito bien o que el alumno exista");
        }
    }

    /**
     * Metodo que muestra los alumnos de un grupo que le diremos
     */
    public static void mostrarAlumnosDeGrupo(){
        String grupo = solicitarCosas.solicitarStringSinLimite("Introduzca el grupo que desea consultar: ");
        Alumno[] alumnosGrupo = centro.alumnosPorGrupo(grupo);
        boolean tieneAlumnosDentro = false;

        for (int i = 0; i < alumnosGrupo.length; i++) {
            if (alumnosGrupo[i] != null) {
                tieneAlumnosDentro = true;
                System.out.println(alumnosGrupo[i].toString());
            }
        }

        if (!tieneAlumnosDentro) {
            System.err.println("No hay alumnos en este grupo o no existe el grupo.");
        }
    }

    //No lo consigo hacer que funcione conio
    public static void mostrarAlumnosPorEdad(){
        int edad = solicitarCosas.solicitarInt("Introduzca la edad que desea consultar: ",0);
        Alumno[] alumnosEdad = centro.alumnosPorEdad(edad);
        boolean tieneAlumnosDentro = false;

        for (int i = 0; i < alumnosEdad.length ; i++) {
            if (alumnosEdad[i] != null){
                tieneAlumnosDentro = true;
                System.out.println(alumnosEdad[i].toString());
            }
        }
        if (!tieneAlumnosDentro){
            System.err.println("No hay alumnos que contengan esa edad");
        }
    }

    /**
     * Muestra el alumna con el NIA seleccionado
     */
    public static void mostrarAlumnosPorNia(){
        int nia = solicitarCosas.solicitarInt("Introduzca el NIA que desea consultar: ",0);
        boolean niaVerificado = centro.buscarNia(nia);
        Alumno[] alumnoNia = centro.alumnoPorNia(nia);
        if (niaVerificado){
            System.out.println(Arrays.toString(alumnoNia));
        }
        else {
            System.err.println("No existe *Carita triste*");
        }
    }

    /**
     * Muestra la consulta de los alumnos con el apellido que introduciremos despues
     */
    public static void mostrarAlumnosPorApellidos(){
        String apellidos = solicitarCosas.solicitarStringSinLimite("Introduzca los apellidos: ");
        Alumno[] alumnosApellidos = centro.alumnoPorApellidos(apellidos);
        boolean tieneAlumnosDentro = false;
        for (int i = 0; i < alumnosApellidos.length ; i++) {
            if (alumnosApellidos[i] != null){
                tieneAlumnosDentro = true;
                System.out.println(alumnosApellidos[i].toString());
            }
        }
        if (!tieneAlumnosDentro){
            System.err.println("No hay alumnos con esos apellidos");
        }
    }

    public static void main(String[] args) {
        principalMenu();
    }
}
