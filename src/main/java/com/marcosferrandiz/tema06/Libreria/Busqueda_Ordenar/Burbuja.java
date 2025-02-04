package com.marcosferrandiz.tema06.libreria.Busqueda_Ordenar;

import java.util.Arrays;

public class Burbuja {
    public static void main(String[] args) {
        int[] array = new int[]{4,6,4,10,6,4,9,1,5,4};
        System.out.println(Arrays.toString(array));
        ordenarBurbuja(array);
        System.out.println(Arrays.toString(array));

    }

    public static void intercambio(int[] array, int posicionOrigen, int posicionDestino){
        int aux = array[posicionOrigen];
        array[posicionOrigen] = array[posicionDestino];
        array[posicionDestino] = aux;
    }

    public static void ordenarBurbuja(int[] array){
        int ultimo = array.length;
        boolean hayCambios;
        for (int i = 0; i < array.length ; i++) {
            hayCambios = false;
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    intercambio(array, j, j + 1);
                    hayCambios = true;
                }
            }
            if (!hayCambios){
                return;
            }
            ultimo--;
        }
    }
}
