package com.marcosferrandiz.tema06.pilaArrays;

import com.marcosferrandiz.tema06.libreria.aleatorios;

public class Ejercicio6 {
    public static final int ELEMENT_COUT = 3;
    public static final int VECES_REPETIR = 9;

    public static void main(String[] args) {
        Cola cola = new Cola(ELEMENT_COUT);

        for (int i = 0; i <= VECES_REPETIR; i++) {
            System.out.println(cola);
            cola.push(aleatorios.aleatorio(0,100));
        }
        for (int i = 0; i <= VECES_REPETIR ; i++) {
            System.out.println(cola.peek());
            cola.pop();
            System.out.println(cola);
        }
    }
}
