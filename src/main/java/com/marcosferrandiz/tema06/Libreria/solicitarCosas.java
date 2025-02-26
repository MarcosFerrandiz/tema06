package com.marcosferrandiz.tema06.libreria;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class solicitarCosas {
    /**
     * Solicita un texto y valida que su longitud este comprendida entre longitudMinima y longitudMaxima
     * @param mensaje Mensaje que se le mostrará al usuario
     * @param longitudMinima Número minimo de caracteres que debe tener el texto
     * @param longitudMaxima Número maximo de caracteres que debe tener un texto
     * @return El texto leido valido
     */
    public static String solicitarString(String mensaje, int longitudMinima, int longitudMaxima){
        Scanner scanner = new Scanner(System.in);
        boolean valido;
        String resultado;
        do {
            System.out.println(mensaje);
            resultado = scanner.nextLine();
            valido = resultado.length() >= longitudMinima && resultado.length() <= longitudMaxima;
            if (!valido) {
                System.err.printf("La longitud no es correcta, deberá de estar entre %d - %d\n",longitudMinima,longitudMaxima);
            }
        }while (!valido);
        return resultado;
    }

    /**
     * Solicita al usuario un entero y que este entre el numero minimo y el numero maximo
     * @param mensaje El mensaje a mostrar
     * @param numMin El numero minimo
     * @param numMax El numero maximo
     * @return devuelve el numero
     */
    public static Integer solicitarEntero(String mensaje, int numMin, int numMax){
        Scanner scanner = new Scanner(System.in);
        boolean valido;
        int num;

        do {
            System.out.println(mensaje);
            num = Integer.parseInt(scanner.nextLine());
            valido = num >= numMin && num <= numMax;

            if (!valido){
                System.err.printf("El numero no es válido, debe de estar entre el %d - %d\n", numMin, numMax);
            }

        }while (!valido);
        return num;

    }

    /**
     * Solicita al usuario un double y que este entre el numero minimo y el numero maximo
     * @param mensaje El mensaje a mostrar
     * @param numMin El numero minimo
     * @param numMax El numero maximo
     * @return devuelve el numero
     */
    public static Double solicitarDoubles(String mensaje, double numMin, double numMax){
        Scanner scanner = new Scanner(System.in);
        boolean valido;
        double num;

        do {
            System.out.println(mensaje);
            num = Double.parseDouble(scanner.nextLine());
            valido = num >= numMin && num <= numMax;

            if (!valido){
                System.err.printf("El numero no es válido, debe de estar entre el %d - %d\n", numMin, numMax);
            }

        }while (!valido);
        return num;
    }

    /**
     * Solicita un array double
     * @param array El array donde quiere meter la información
     */
    public static  void solicitarDatosArray(double[] array){
        Scanner input = new Scanner(System.in);
        if (array == null){
            return;
        }
        for (int i = 0; i < array.length; i++){
            System.out.printf("a[%d]?\n", i);
            array[i] = Double.parseDouble(input.nextLine());
        }
    }

    /**
     * Solicita un array entero
     * @param array El array donde quiere meter la información
     */
    public static  void solicitarDatosArray(int[] array){
        Scanner input = new Scanner(System.in);
        if (array == null){
            return;
        }
        for (int i = 0; i < array.length; i++){
            System.out.printf("a[%d]?\n", i);
            array[i] = Integer.parseInt(input.nextLine());
        }
    }

    /**
     * Solicita un array caracter
     * @param array El array donde quiere meter la información
     */
    public static  void solicitarDatosArray(char[] array){
        Scanner input = new Scanner(System.in);
        if (array == null){
            return;
        }
        for (int i = 0; i < array.length; i++){
            System.out.printf("a[%d]?\n", i);
            array[i] = input.nextLine().charAt(0);
        }
    }

    /**
     * Solicita un texto y valida su longitud que no sea menor al numero nMin, devuelve el numero puesto
     *
     * @param msj El mensaje con el que se solicita el número
     * @param nMin Número mínimo permitido
     * @return devuelve el número introducido
     */
    public static int solicitarInt(String msj, int nMin) {
        Scanner input = new Scanner(System.in);
        int num;
        boolean check = true;
        do {
            if (!check) {
                System.err.println("Número introducido incorrecto, intentalo de nuevo.");
            }
            System.out.println(msj);
            num = Integer.parseInt(input.nextLine());
            check = num >= nMin;
        } while (!check);

        return num;
    }


    /**
     * Solicita un numero double al usuario y comprueba de que sea un booleano
     * @param mensaje Es el mensaje donde pondremos lo que deberá de introducir el usuario
     * @return Devuelve el numero verificado y todo
     */
    public static double obtenerNumero(String mensaje){
        Scanner input = new Scanner(System.in);
        String entrada = "";
        double numero = 0;
        boolean validacion = false;
        while (!validacion){
            System.out.println(mensaje);
            entrada = input.nextLine();
            if (esNumero(entrada)){
                numero = Double.parseDouble(entrada);
                validacion = true;
            }
            else {
                System.err.println("No valido, porfavor introduzca un número");
            }
        }
        return numero;
    }

    /**
     * Booleano que te dice si el String introducido es un numero o cualquier otra cosa
     * @param entrada Es el string el cual queremos saber si es un numero
     * @return Devolvera true en el caso de que se un numero, o false en el caso de que no
     */
    public static boolean esNumero(String entrada) {
        if (entrada == null || entrada.isEmpty()) {
            return false;
        }

        String patron = "^[+-]?\\d*(\\.\\d+)?$";

        return entrada.matches(patron);
    }

    /**
     * Solicita un valor booleano al usuario (true o false)
     *
     * @param mensaje Es el mensaje que se mostrará para pedir el valor
     * @return Devuelve el valor booleano ingresado por el usuario
     */
    public static boolean solicitarBoolean(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        boolean valido = false;
        boolean resultado = false;

        do {
            System.out.println(mensaje + " (true/false)");
            String entrada = scanner.nextLine();
            if (entrada.equalsIgnoreCase("true") || entrada.equalsIgnoreCase("false")) {
                resultado = Boolean.parseBoolean(entrada);
                valido = true;
            } else {
                System.err.println("Entrada no válida. Por favor, ingrese 'true' o 'false'.");
            }
        } while (!valido);

        return resultado;
    }


    /**
     * Solicita una fecha al usuario en el formato especificado y valida si la entrada es correcta.
     *
     * @param mensaje        Mensaje que se mostrará al usuario
     * @param formatoFormato Formato de la fecha esperado (por ejemplo, "dd/MM/yyyy")
     * @return La fecha ingresada como un objeto LocalDate
     */
    public static LocalDate solicitarFecha(String mensaje, String formatoFormato) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFormato);
        LocalDate fecha = null;
        boolean valido = false;

        do {
            try {
                System.out.println(mensaje + " (" + formatoFormato + "):");
                String entrada = scanner.nextLine();
                fecha = LocalDate.parse(entrada, formatter);
                valido = true;
            } catch (DateTimeParseException e) {
                System.err.println("Fecha no válida. Por favor, introduzca la fecha en el formato " + formatoFormato + ".");
            }
        } while (!valido);

        return fecha;
    }


    /**
     * Solicita al usuario un double con un número mínimo
     *
     * @param mensaje      El mensaje a mostrar
     * @param numeroMinimo El número mínimo permitido
     * @return Devuelve el número double introducido
     */
    public static Double solicitarDoubleConMinimo(String mensaje, double numeroMinimo) {
        Scanner scanner = new Scanner(System.in);
        double num;
        boolean valido;

        do {
            try {
                System.out.println(mensaje);
                num = Double.parseDouble(scanner.nextLine());
                valido = num >= numeroMinimo;

                if (!valido) {
                    System.err.printf("El número debe ser mayor o igual a %.2f\n", numeroMinimo);
                }
            } catch (NumberFormatException e) {
                System.err.println("Entrada no válida. Por favor, introduzca un número válido.");
                valido = false;
                num = 0; // Valor temporal para evitar errores de compilación
            }
        } while (!valido);

        return num;
    }


    /**
     * Solicita un texto al usuario sin límite de longitud.
     *
     * @param mensaje El mensaje que se mostrará para solicitar el texto.
     * @return Devuelve el texto introducido por el usuario.
     */
    public static String solicitarStringSinLimite(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(mensaje);
        return scanner.nextLine();
    }

    /**
     * Solicita un solo carácter al usuario.
     *
     * @param mensaje El mensaje que se mostrará para pedir el carácter.
     * @return Devuelve el carácter ingresado por el usuario.
     */
    public static char solicitarCaracter(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        char caracter = '\0';
        boolean valido = false;

        do {
            System.out.println(mensaje);
            String entrada = scanner.nextLine();

            if (entrada.length() == 1) {
                caracter = entrada.charAt(0);
                valido = true;
            } else {
                System.err.println("Entrada no válida. Por favor, ingrese un único carácter.");
            }
        } while (!valido);

        return caracter;
    }



    
}
