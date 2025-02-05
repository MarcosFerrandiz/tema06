package com.marcosferrandiz.tema06.pilaArrays;

import com.marcosferrandiz.tema06.libreria.aleatorios;

public class Ejercicio1 {
    public static final int TAMANYO_ARRAY = 9;
    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray(TAMANYO_ARRAY);

        for (int i = 0; i <= TAMANYO_ARRAY ; i++) {
            dynamicArray.add(aleatorios.nnumeroAleatorio(0,100));
        }
        System.out.println(dynamicArray.toString());

        for (int i = 0; i <= TAMANYO_ARRAY ; i++) {
            System.out.printf("dynamicArray[%d] = %.2f \n",i, dynamicArray.get(i));
        }


        dynamicArray.add(2,85);
        System.out.println(dynamicArray);
        dynamicArray.add(69);
        System.out.println(dynamicArray);

        dynamicArray.remove(0);
        System.out.println(dynamicArray);
        dynamicArray.remove(69.0);
        System.out.println(dynamicArray);

        System.out.println(dynamicArray.get(6));

        dynamicArray.set(9,55);
        System.out.println(dynamicArray);

        System.out.println(dynamicArray.size());


    }
}
