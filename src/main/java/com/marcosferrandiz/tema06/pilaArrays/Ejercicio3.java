package com.marcosferrandiz.tema06.pilaArrays;

import java.util.Scanner;

public class Ejercicio3 {
    public enum APERTURAS {
        LLAVE('{', 1),
        CORCHETE('[', 3),
        PARENTESIS('(', 4),
        LLAVECIERRE('}', 2),
        CORCHETECIERRE(']', 6),
        PARENTESISCIERRE(')', 8);

        private final int valor;

        APERTURAS(char simbolo, int valor) {
            this.valor = valor;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        if (args.length == 0) {
            System.out.println("Uso: java Ej3Pila <archivo.txt>");
            return;
        }

        System.out.println("Escriba el código");
        String contenido = input.nextLine();
        if (contenido.isEmpty()) {
            System.err.println("Error: No se pudo leer el archivo.");
            return;
        }
        validarDelimitadores(contenido);
    }

    public static void validarDelimitadores(String contenido) {
        Pila p1 = new Pila(100);

        for (char caracter : contenido.toCharArray()) {
            int valor = switch (caracter) {
                case '{' -> APERTURAS.LLAVE.valor;
                case '[' -> APERTURAS.CORCHETE.valor;
                case '(' -> APERTURAS.PARENTESIS.valor;
                case '}' -> APERTURAS.LLAVECIERRE.valor;
                case ']' -> APERTURAS.CORCHETECIERRE.valor;
                case ')' -> APERTURAS.PARENTESISCIERRE.valor;
                default -> -1;
            };

            if (valor == -1) continue; // ignoramos cualq otro caracter

            if (valor == 1 || valor == 3 || valor == 4) {
                p1.push(valor);
            } else if (valor == 2 || valor == 6 || valor == 8) {
                if (p1.isEmpty() || p1.top() != valor / 2) {
                    System.out.println("Error: Cierre inesperado '" + caracter + "'");
                    return;
                }
                p1.pop();
            }
        }

        System.out.println(p1.isEmpty() ? "El código fuente está bien." : "Error: delimitadores de apertura sin cerrar.");
    }
}
