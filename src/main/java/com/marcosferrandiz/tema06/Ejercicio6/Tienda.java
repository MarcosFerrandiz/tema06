package com.marcosferrandiz.tema06.Ejercicio6;

import java.util.Arrays;
import java.util.GregorianCalendar;

public class Tienda {
    private Bicicleta[] bicicletas;
    private static int contadorIndice;

    public static int getContadorIndice() {
        return contadorIndice;
    }

    public static void setContadorIndice(int contadorIndice) {
        Tienda.contadorIndice = contadorIndice;
    }

    @Override
    public String toString() {
        return "Tienda{" +
                "bicicletas=" + Arrays.toString(bicicletas) +
                '}';
    }
}
