package com.marcosferrandiz.tema06.Ejercicio6;

import com.marcosferrandiz.tema06.libreria.solicitarCosas;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.GregorianCalendar;

public class Ejercicio6 {
    private static Tienda tienda = new Tienda();

    private static void inicializarInventario() {
        tienda.anyadirBicicleta("Agente001", "Apple", "Rick owens", 8.0, 28, false, LocalDate.of(2020, 5, 15), 1500.00, 5);
        tienda.anyadirBicicleta("Agente002", "Hecendado", "Federico Lorca", 9.0, 27, false, LocalDate.of(2021, 8, 12), 2000.00, 3);
        tienda.anyadirBicicleta("Agente003", "Durex", "Mixto", 12.5, 29, true, LocalDate.of(2022, 3, 27), 3500.00, 2);
    }

    private static void mostrarMenu() {
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

    private static void anyadirBicicleta() {
        String referencia = solicitarCosas.solicitarStringSinLimite("Introduce la referencia de la bicicleta: ");
        String marca = solicitarCosas.solicitarStringSinLimite("Introduce la marca de la bicicleta: ");
        String modelo = solicitarCosas.solicitarStringSinLimite("Introduce el modelo de la bicicleta: ");
        double peso = solicitarCosas.solicitarDoubleConMinimo("Introduce el peso de la bicicleta: ", 0.0);
        int tamanoRuedas = solicitarCosas.solicitarInt("Introduce el tamaño de las ruedas: ",0);
        boolean motor = solicitarCosas.solicitarBoolean("Tiene motor? ( True | False ) ");
        LocalDate fechaFabricacion = solicitarCosas.solicitarFecha("Introduce la fecha de fabricacion: ","dd/MM/yyyy");
        double precio = solicitarCosas.solicitarDoubleConMinimo("Introduce el precio de la bicicleta: ", 0.0);
        int cantidad = solicitarCosas.solicitarInt("Introduce la cantidad que quiera añadir: ",0);

        tienda.anyadirBicicleta(referencia,marca,modelo,peso,tamanoRuedas,motor,fechaFabricacion,precio,cantidad);
    }

    private static void mostrarStock(){
        System.out.println("Inventario de bicicletas:");
        System.out.println(tienda.toString());
    }

    private static void venderBicicleta() {
        String referencia = solicitarCosas.solicitarStringSinLimite("Introduce la referencia de la bicicleta que quieres vender: ");
        Bicicleta bicicleta = tienda.buscarPorReferencia(referencia);

        boolean ventaAceptada = tienda.venderBicicleta(referencia);
        if (ventaAceptada) {
            System.out.println("La venta de la bicicleta "+bicicleta+" ha sido exitosa");
        } else {
            System.out.println("No se ha podido realizar la venta de la bicicleta "+bicicleta+" ya sea porque no existe o porque no quedan ");
        }
    }

    private static void consultarBicicleta() {
        System.out.println("Seleccione el criterio de consulta:");
        System.out.println("1.- Por referencia");
        System.out.println("2.- Por marca");
        System.out.println("3.- Por modelo");
        int opcion = solicitarCosas.solicitarEntero("Tu opción: ",0,4);

        switch (opcion) {
            case 1:
                buscarPorReferencia();
                break;
            case 2:
                buscarPorMarca();
                break;
            case 3:
                buscarPorModelo();
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void buscarPorReferencia() {
        String referencia = solicitarCosas.solicitarStringSinLimite("Introduce la referencia: ");
        boolean verificacionReferencia = tienda.buscarReferencia(referencia);
        Bicicleta[] bicicletaEncontrada = tienda.consultaPorReferencia(referencia);
        if (verificacionReferencia){
            System.out.println(Arrays.toString(bicicletaEncontrada));
        }
        else {
            System.err.println("No existe *Carita triste*");
        }
    }

    private static void buscarPorMarca() {
        String marca = solicitarCosas.solicitarStringSinLimite("Introduce la marca: ");
        boolean verificacionMarca = tienda.buscarMarca(marca);
        Bicicleta[] bicicletaEncontrada = tienda.consultaPorMarca(marca);
        if (verificacionMarca){
            System.out.println(Arrays.toString(bicicletaEncontrada));
        }
        else {
            System.err.println("No existe *Carita triste*");
        }
    }

    private static void buscarPorModelo() {
        String modelo = solicitarCosas.solicitarStringSinLimite("Introduce el modelo: ");
        boolean verificacionModelo = tienda.buscarModelo(modelo);
        Bicicleta[] bicicletaEncontrada = tienda.consultaPorModelo(modelo);
        if (verificacionModelo){
            System.out.println(Arrays.toString(bicicletaEncontrada));
        }
        else {
            System.err.println("No existe *Carita triste*");
        }
    }

    public static void main(String[] args) {
        inicializarInventario();
        mostrarMenu();
    }
}
