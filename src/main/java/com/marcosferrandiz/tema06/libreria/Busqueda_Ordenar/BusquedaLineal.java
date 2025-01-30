package com.marcosferrandiz.examen.libreria.Busqueda_Ordenar;

public class BusquedaLineal {
    public static void main(String[] args) {
        int[] array = {1,30,20,1,5,100,5,7,100,1000};
        int buscar = 31;
        boolean encontrado = false;
        for (int i = 0; i < array.length-1;i++){
            if (buscar == array[i]){
                encontrado = true;
                System.out.println("se ha encontrado en la posicion: " + i);
                break;
            }
        }
        if (!encontrado){
            System.out.println("no se ha encontrado");
        }
    }
}
