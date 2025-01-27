package com.marcosferrandiz.tema06.Ejercicio4;

public class Ejercicio4 {
    public static void main(String[] args) {
        punto p1 = new punto(2.0, 6.2);
        punto p2 = new punto(1.5, 3.8);
        punto p3 = new punto();

        System.out.println("P1: " +p1);
        System.out.println("P2: " +p2);
        System.out.println("P3: " +p3);

        System.out.println("Distancia entre P1 y P2: "+ p1.distancia(p2));
    }
}
