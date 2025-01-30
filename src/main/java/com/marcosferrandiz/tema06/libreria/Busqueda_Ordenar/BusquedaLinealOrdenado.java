package com.marcosferrandiz.examen.libreria.Busqueda_Ordenar;

public class BusquedaLinealOrdenado {
    public static void main(String[] args) {
        int[] array = {1,20,100,100,1000};
        int buscar = 100;
        for (int i = 0; i <= array.length-1;i++){
            if (buscar == array[i]){
                System.out.println("se ha encontrado en la posicion: " + i);
                break;
            } else if (buscar < array[i] || i == array.length-1){
                System.out.println("no se ha encontrado");
            }
        }
    }
}
