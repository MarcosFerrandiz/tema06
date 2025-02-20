package com.marcosferrandiz.tema06.Ejercicio6;

import com.marcosferrandiz.tema06.libreria.solicitarCosas;

import java.time.LocalDate;
import java.util.Scanner;

public class Tienda {
    private static final int TAMANO_MAX = 100;
    private static Bicicleta[] inventario = new Bicicleta[TAMANO_MAX];
    private static int contadorBicicletas = 0;

    public void inicializarInventario() {
        inventario[contadorBicicletas++] = new Bicicleta("Agente001", "Apple", "Rick owens", 8.0, 28, false, LocalDate.of(2020, 5, 15), 1500.00, 5);
        inventario[contadorBicicletas++] = new Bicicleta("Agente002", "Hecendado", "Federico Lorca", 9.0, 27, false, LocalDate.of(2021, 8, 12), 2000.00, 3);
        inventario[contadorBicicletas++] = new Bicicleta("Agente003", "Durex", "Mixto", 12.5, 29, true, LocalDate.of(2022, 3, 27), 3500.00, 2);
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("*************************");
            System.out.println("** GESTIÓN DE BICICLETAS **");
            System.out.println("*************************");
            System.out.println("1.- Añadir bicicleta");
            System.out.println("2.- Vender bicicleta");
            System.out.println("3.- Consultar bicicleta");
            System.out.println("4.- Mostrar stock");
            System.out.println("------------------------------------");
            System.out.println("0.- Salir");
            int opcion = solicitarCosas.solicitarEntero("Selecciona una opción: ",0,5);

            switch (opcion) {
                case 1:
                    anyadirBicicleta();
                    break;
                case 2:
                    venderBicicleta();
                    break;
                case 3:
                    consultarBicicleta();
                    break;
                case 4:
                    mostrarStock();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }
        }
    }

    private void anyadirBicicleta() {
        if (contadorBicicletas >= TAMANO_MAX) {
            System.out.println("No se pueden añadir más bicicletas, el inventario está lleno.");
            return;
        }

        System.out.print("Introduce la referencia de la bicicleta: ");
        String referencia = solicitarCosas.solicitarStringSinLimite("Introduce la referencia de la bicicleta: ");
        Bicicleta bicicleta = buscarPorReferencia(referencia);

        if (bicicleta != null) {
            System.out.println("La bicicleta con esta referencia ya existe. Incrementando stock.");
            int cantidad = solicitarCosas.solicitarInt("Cantidad a añadir: ",0);
            bicicleta.setExistencias(bicicleta.getExistencias() + cantidad);
        } else {
            String marca = solicitarCosas.solicitarString("Introduce la marca: ",0,30);
            String modelo = solicitarCosas.solicitarString("Introduce el modelo: ",0,30);
            double peso = solicitarCosas.solicitarDoubleConMinimo("Introduce el peso en kg: ",0);
            int tamanoRuedas = solicitarCosas.solicitarInt("Introduce el tamaño de las ruedas en pulgadas: ",0);
            boolean tieneMotor = solicitarCosas.solicitarBoolean("¿Tiene motor?: ");
            LocalDate fechaFabricacion = solicitarCosas.solicitarFecha("Introduce la fecha de fabricación: ","dd/MM/yyyy");
            double precio = solicitarCosas.solicitarDoubleConMinimo("Introduce el precio: ",0);
            int existencias = solicitarCosas.solicitarInt("Introduce el número de existencias: ",0);

            inventario[contadorBicicletas++] = new Bicicleta(referencia, marca, modelo, peso, tamanoRuedas, tieneMotor, fechaFabricacion, precio, existencias);
            System.out.println("Bicicleta añadida correctamente.");
        }
    }

    private void venderBicicleta() {
        String referencia = solicitarCosas.solicitarStringSinLimite("Introduce la referencia de la bicicleta que quieres vender: ");
        Bicicleta bicicleta = buscarPorReferencia(referencia);

        if (bicicleta != null && bicicleta.getExistencias() > 0) {
            bicicleta.setExistencias(bicicleta.getExistencias() - 1);
            System.out.println("Bicicleta " + referencia + " vendida correctamente.");
        } else {
            System.out.println("No hay stock para la bicicleta con referencia " + referencia + ".");
        }
    }

    private void consultarBicicleta() {
        System.out.println("Seleccione el criterio de consulta:");
        System.out.println("1.- Por referencia");
        System.out.println("2.- Por marca");
        System.out.println("3.- Por modelo");
        int opcion = solicitarCosas.solicitarEntero("Tu opción: ",0,4);

        switch (opcion) {
            case 1:
                String referencia = solicitarCosas.solicitarStringSinLimite("Introduce la referencia: ");
                Bicicleta bicicleta = buscarPorReferencia(referencia);
                if (bicicleta != null) {
                    System.out.println(bicicleta);
                } else {
                    System.out.println("No se encontró una bicicleta con esa referencia.");
                }
                break;
            case 2:
                String marca = solicitarCosas.solicitarStringSinLimite("Introduce la marca: ");
                for (Bicicleta bici : inventario) {
                    if (bici != null && bici.getMarca().equalsIgnoreCase(marca)) {
                        System.out.println(bici);
                    }
                }
                break;
            case 3:
                System.out.print("Introduce el modelo: ");
                String modelo = solicitarCosas.solicitarStringSinLimite("Introduce el modelo: ");
                for (Bicicleta bici : inventario) {
                    if (bici != null && bici.getModelo().equalsIgnoreCase(modelo)) {
                        System.out.println(bici);
                    }
                }
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private void mostrarStock() {
        System.out.println("Inventario de bicicletas:");
        for (Bicicleta bici : inventario) {
            if (bici != null) {
                System.out.println(bici);
                System.out.println("--------------------");
            }
        }
    }

    private Bicicleta buscarPorReferencia(String referencia) {
        for (Bicicleta bicicleta : inventario) {
            if (bicicleta != null && bicicleta.getReferencia().equalsIgnoreCase(referencia)) {
                return bicicleta;
            }
        }
        return null;
    }
}
