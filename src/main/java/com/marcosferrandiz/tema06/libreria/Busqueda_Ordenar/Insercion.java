package com.marcosferrandiz.examen.libreria.Busqueda_Ordenar;

import com.marcosferrandiz.examen.libreria.aleatorios;

import java.util.Arrays;

public class Insercion {
    public static void main(String[] args) {
        int[] array = new int[10];
        aleatorios.rellenarArrayAleatoriamente(array, 1, 11);
        System.out.println(Arrays.toString(array));
        ordenaInsercion(array);

    }
    public static void ordenaInsercion(int[] array){
        int aux;
        for (int i = 1; i < array.length; i++){
            aux = array[i];
            int j;
            for (j = i -1; j >= 0; j--) {
                if (array[j] > aux){
                    array[j +1] = array[j];
                    array[j] = aux;
                } else if (array[j] < aux) {
                    break;
                }
            }
            array[j + 1] = aux;
        }
        System.out.println(Arrays.toString(array));
    }
}
