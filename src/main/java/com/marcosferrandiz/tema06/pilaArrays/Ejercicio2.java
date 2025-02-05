package com.marcosferrandiz.tema06.pilaArrays;

import com.marcosferrandiz.tema06.libreria.aleatorios;

public class Ejercicio2 {
    public static final int ELEMENT_COUT = 3;
    public static final int VECES_REPETIR = 9;

    public static void main(String[] args) {
        Pila pila = new Pila(ELEMENT_COUT);

        for (int i = 0; i <= VECES_REPETIR; i++) {
            System.out.println(pila);
            pila.push(aleatorios.aleatorio(0,100));
        }
        for (int i = 0; i <= VECES_REPETIR ; i++) {
            System.out.println(pila.top());
            pila.pop();
            System.out.println(pila);
        }
    }
}
