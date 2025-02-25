package com.marcosferrandiz.tema06.Ejercicio2;

public class Main {
    public static void main(String[] args) {
        Asignatura asignatura = new Asignatura("Programación",1017,1);
        Asignatura asignatura2 = new Asignatura("Entornos",1017,2);
        System.out.println(asignatura);
        System.out.println(asignatura2);
        System.out.println(asignatura.equals(asignatura2));
    }
}
