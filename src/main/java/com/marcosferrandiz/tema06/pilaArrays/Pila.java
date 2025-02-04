package com.marcosferrandiz.tema06.pilaArrays;


import com.marcosferrandiz.tema06.libreria.toStrings;

public class Pila {
    private int[] pila;
    private int tope;
    private int capacidad;

    public Pila(int capacidad) {
        this.pila = new int[capacidad];
        this.tope = -1;
        this.capacidad = capacidad;
    }

    public void push(int elemento){
        if (tope == capacidad -1){
            System.err.println("La pila esta completamente llena");
        }
        tope++;
        pila[tope] = elemento;
    }

    public boolean vacio(){
        return tope == -1;
    }
    public int pop(){
        if (vacio()){
            System.err.println("La pila esta completamente vacia");
        }
        int elemento = pila[tope];
        tope--;
        return elemento;
    }

    public int tamanyo(){
        return tope + 1;
    }

    public int top(){
        if (vacio()){
            System.err.println("La pila esta completamente vacia");
        }
        return pila[tope];
    }

    public void imprimirPila(){
        System.out.print("[ ");
        for (int i = 0; i <= tope ; i++) {
            System.out.print(pila[i] + " | ");
        }
        System.out.println(" ]");
    }

    public static void main(String[] args) {
        Pila pila = new Pila(5);

        pila.imprimirPila();

        pila.push(70);
        pila.push(5);
        pila.push(20);

        pila.imprimirPila();

        System.out.println("Primer elemento de todos: "+ pila.top());
        System.out.println("Tamaño de la pila: "+ pila.tamanyo());
        pila.pop();
        System.out.println("Se ha quitado el de arriba del todo");
        pila.imprimirPila();
    }
}
