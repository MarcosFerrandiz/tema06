package com.marcosferrandiz.tema06.libreria.Busqueda_Ordenar;

public class ArrayEstadisticas {
    private final int[] array;
    private int min;
    private int max;

    public ArrayEstadisticas(int[] array){
        this.array = array;
        min = array[0];
        max = array[0];
        for (int i = 1; i< array.length; i++){
            if (array[i]> max){
                max = array[i];
            }else if (array[i]< min){
                min = array[i];
            }
        }
    }

    public int[] getArray() {
        return array;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }
}
