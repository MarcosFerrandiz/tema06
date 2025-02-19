package com.marcosferrandiz.tema06.Ejercicio6;

import com.marcosferrandiz.tema06.libreria.solicitarCosas;

import java.util.GregorianCalendar;

public class Ejercicio6 {
    public static int MAX_SIZE = 100;
    public static Bicicleta[] bicicleta = new Bicicleta[MAX_SIZE];
    public static void main(String[] args) {
        int deci = 0;
        int deci2 = 0;
        do {
            menuPrincipal();
            deci = solicitarCosas.solicitarEntero("",0,5);

            switch (deci){
                case 1:
                case 2:
                case 3:{
                    menuConsulta();
                    deci2 = solicitarCosas.solicitarEntero("",0,4);
                }
                case 4:
                case 0: break;
                default:
            }
        }while (deci == 0);
    }

    public static void menuPrincipal(){
        System.out.println("*************************");
        System.out.println("** GESTIÓN DE BICICLETAS **");
        System.out.println("*************************");
        System.out.println("1.- Añadir bicicleta ...");
        System.out.println("2.- Vender bicicleta ...");
        System.out.println("3.- Consultar bicicleta ...");
        System.out.println("4.- Mostrar stock");
        System.out.println("------------------------------------");
        System.out.println("0.- Salir");
    }

    public static void menuConsulta(){
        System.out.println("***********************");
        System.out.println("** CONSULTA BICICLETA **");
        System.out.println("***********************");
        System.out.println("1.- Consultar por referencia ...");
        System.out.println("2.- Consultar por marca ...");
        System.out.println("3.- Consultar por modelo ...");
        System.out.println("---------------------------------");
        System.out.println("0.- Volver al menú principal");
    }

    public void add(){
        String referencia = solicitarCosas.solicitarString("Introduzca el numero de referencia",0,100);

        for (int i = 0; i < bicicleta.length ; i++) {
            if (bicicleta[i].getReferencia().equals(referencia) && bicicleta[i] != null){
                System.out.println("La bicicleta se ha añadido correctamente a su referencia");
                bicicleta[i].setStock(bicicleta[i].getStock()+1);
                return;
            }
        }
        String marca = solicitarCosas.solicitarString("Introduzca la marca",0,100);
        String modelo = solicitarCosas.solicitarString("Introduzca el modelo",0,100);
        double peso = solicitarCosas.solicitarDoubles("Introduzca el peso (kg)",0,999999999);
        double tamanyo = solicitarCosas.solicitarDoubles("Introduzca el tamaño (pulgadas)",0,999999999);
        boolean motor = true;
        String deciMotor;
        do {
            deciMotor = solicitarCosas.solicitarString("¿Tiene motor? (s | n)",0,2);
            if (deciMotor.equals("s")){
                motor = true;
            }if (deciMotor.equals("n")){
                motor = false;
            }else {
                System.err.println("Caracter no válido");
            }
        }while (deciMotor.equals("s") || deciMotor.equals("n"));
        String fechFab = solicitarCosas.solicitarString("Introduzca la fecha de fabricacion (YYYY/MM/DD)",0,9);
        double precio = solicitarCosas.solicitarDoubles("Introduzca el precio de la bicicleta",0,999999999);
        int stock = solicitarCosas.solicitarInt("¿Cuantas bicicletas desea añadir al stock?",0);
        for (int i = 0; i < bicicleta.length ; i++) {
            if (bicicleta[i] == null){
                bicicleta[i] = new Bicicleta(referencia,marca,modelo,peso,tamanyo,motor,fechFab,precio,stock);
                System.out.println("Registrada corerctamente");
                return;
            }
        }
        System.out.println("No hay espacio para agregar nuevas bicicletas, pero si para aumentar el stock");
    }
}
