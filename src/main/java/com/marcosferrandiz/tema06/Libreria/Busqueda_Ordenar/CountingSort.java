package com.marcosferrandiz.tema06.libreria.Busqueda_Ordenar;

import com.marcosferrandiz.tema06.libreria.aleatorios;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] array = new int[10];
        aleatorios.rellenarArrayAleatoriamente(array, 1, 10);
        ordenaContando(array);

    }
    public static void ordenaContando(int[] array){
        final int DISTANCIA_MAXIMA = 100000;
        ArrayEstadisticas arrayEstadisticas = new ArrayEstadisticas(array);
        int min = arrayEstadisticas.getMin();
        int max = arrayEstadisticas.getMax();
        if (max - min + 1 > DISTANCIA_MAXIMA){
            System.err.println("Hay demasiada dispersión en los datos");
            return;
        }

        int[] arrayConteo = new int[max+1];
        for (int i = 0; i < array.length ; i++) {
            arrayConteo[array[i]]++;
        }


        int contador = 0;
        for (int i = 0; i < arrayConteo.length ; i++) {
            int cantidad = arrayConteo[i];
            for (int j = 0; j < cantidad; j++){
                array[contador++] = i;
            }
        }
        System.out.println("Conteo: "+ Arrays.toString(arrayConteo));
        System.out.println(Arrays.toString(array));
    }
}
