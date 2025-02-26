package com.marcosferrandiz.tema06.Ejercicio6;

import com.marcosferrandiz.tema06.libreria.solicitarCosas;

import java.time.LocalDate;
import java.util.Arrays;

public class Tienda {
    private final int TAMANO_MAX;
    private Bicicleta[] inventario;
    private static int contadorBicicletas;

    public Tienda() {
        this.TAMANO_MAX = 100;
        this.inventario = new Bicicleta[TAMANO_MAX];
    }

    public boolean verificarSiExisteReferencia(String referencia) {
        for (int i = 0; i < inventario.length ; i++) {
            if (inventario[i] != null && inventario[i].getReferencia().equalsIgnoreCase(referencia)) {
                return true;
            }
        }
        return false;
    }

    public void anyadirBicicleta(String referencia, String marca, String modelo, double peso, int tamanoRuedas, boolean tieneMotor, LocalDate fechaFabricacion, double precio, int existencias) {
        if (contadorBicicletas >= TAMANO_MAX) {
            return;
        }

        boolean existeReferencia = verificarSiExisteReferencia(referencia);
        

        if (existeReferencia) {
            for (int i = 0; i < inventario.length ; i++) {
                if (inventario[i] != null && inventario[i].getReferencia().equalsIgnoreCase(referencia)){
                    inventario[i].setExistencias(inventario[i].getExistencias() + existencias);
                    return;
                }
            }
        } else {
            inventario[contadorBicicletas++] = new Bicicleta(referencia, marca, modelo, peso, tamanoRuedas, tieneMotor, fechaFabricacion, precio, existencias);
        }
    }

    public boolean venderBicicleta(String referencia) {
        Bicicleta bicicleta = buscarPorReferencia(referencia);

        if (bicicleta != null && bicicleta.getExistencias() > 0) {
            bicicleta.setExistencias(bicicleta.getExistencias() - 1);
            return true;
        } else {
            return false;
        }
    }

    public void consultarBicicleta() {
        System.out.println("Seleccione el criterio de consulta:");
        System.out.println("1.- Por referencia");
        System.out.println("2.- Por marca");
        System.out.println("3.- Por modelo");
        int opcion = solicitarCosas.solicitarEntero("Tu opción: ",0,4);

        switch (opcion) {
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

    public boolean buscarReferencia(String referencia) {
        for (int i = 0; i < inventario.length ; i++) {
            if (inventario[i] != null && inventario[i].getReferencia().equalsIgnoreCase(referencia)) {
                return true;
            }
        }
        return false;
    }

    public boolean buscarMarca(String marca) {
        for (int i = 0; i < inventario.length ; i++) {
            if (inventario[i] != null && inventario[i].getMarca().equalsIgnoreCase(marca)) {
                return true;
            }
        }
        return false;
    }

    public boolean buscarModelo(String modelo) {
        for (int i = 0; i < inventario.length ; i++) {
            if (inventario[i] != null && inventario[i].getModelo().equalsIgnoreCase(modelo)) {
                return true;
            }
        }
        return false;
    }

    public Bicicleta[] consultaPorReferencia(String referencia) {
        for (int i = 0; i < inventario.length ; i++) {
            if (inventario[i] != null && inventario[i].getReferencia().equals(referencia)) {
                return new Bicicleta[]{inventario[i]};
            }
        }
        return null;
    }

    public Bicicleta buscarPorReferencia(String referencia) {
        Bicicleta bicicletaEncontrada = null;
        for (int i = 0; i < inventario.length ; i++) {
            if (bicicletaEncontrada != null && bicicletaEncontrada.getReferencia().equalsIgnoreCase(referencia)) {
                return bicicletaEncontrada;
            }
        }
        return null;
    }

    public Bicicleta[] consultaPorMarca(String marca) {
        for (int i = 0; i < inventario.length ; i++) {
            if (inventario[i] != null && inventario[i].getMarca().equals(marca)) {
                return new Bicicleta[]{inventario[i]};
            }
        }
        return null;
    }

    public Bicicleta[] consultaPorModelo(String modelo) {
        for (int i = 0; i < inventario.length ; i++) {
            if (inventario[i] != null && inventario[i].getModelo().equalsIgnoreCase(modelo)) {
                return new Bicicleta[]{inventario[i]};
            }
        }
        return null;
    }

    public Bicicleta buscarPorModelo(String modelo) {
        Bicicleta bicicletaEncontrada = null;
        for (int i = 0; i < inventario.length ; i++) {
            if (bicicletaEncontrada != null && bicicletaEncontrada.getModelo().equalsIgnoreCase(modelo)) {
                return bicicletaEncontrada;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Tienda{" +
                "inventario=" + Arrays.toString(inventario) +
                '}';
    }
}
