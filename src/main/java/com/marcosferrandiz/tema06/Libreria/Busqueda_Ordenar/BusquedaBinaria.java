package com.marcosferrandiz.tema06.libreria.Busqueda_Ordenar;

public class BusquedaBinaria {
    public static void main(String[] args) {
        int[] array = {1,20,30,50,80,100,200,1000};
        int buscar = 20;
        int inicio = 0;
        int fin = array.length - 1;
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;

            if (array[medio] == buscar) {
                System.out.println("se ha encontrado");
            }

            if (array[medio] < buscar) {
                inicio = medio + 1; // Buscar en la mitad superior
            } else {
                fin = medio - 1; // Buscar en la mitad inferior
            }
        }
    }
}
