package com.marcosferrandiz.tema06.generics;


import java.lang.reflect.Array;
import java.util.Arrays;

public class Pila<T> {
    /** Tamaño inicial por defecto */
    private static final int INITIAL_SIZE = 10;
    /** Factor de crecimiento cada vez que el array requiera ser redimensionado */
    private static final float GROW_FACTOR = 2f;
    /** Array donde se van a guardar los valores de la pila */
    private T[] data;
    /** Tamaño actual de la pila */
    private int size;

    /**
     * Crea una pila con el tamaño inicial por defecto INITIAL_SIZE
     */
    public Pila() {
        this(INITIAL_SIZE);
    }

    /**
     * Crea una pila de tamaño inicial recibido como parámetro
     * @param size Capacidad inicial de la pila
     */
    public Pila(int size) {
        data = (T[]) new Object[size];
        this.size = 0;
    }

    /**
     * Añade un elemento a la cima de la pila
     * @param e Elemento a añadir
     */
    public void push(T e) {
        if (isFull()) {
            expand();
        }
        data[size] = e;
        size++;
    }

    /**
     * Expande el tamaño de la pila con el factor de crecimiento indicado por GROW_FACTOR
     */
    private void expand() {
        T[] aux = (T[]) new Object[Math.round(data.length * GROW_FACTOR)];
        for (int i = 0; i < data.length; i++) {
            aux[i] = data[i];
        }
        data = aux;
    }

    /**
     * Extrae el elemento que ocupa la cima de la pila
     * @return El elemento de la cima o Double.NEGATIVE_INFINITY si la pila está vacía
     */
    public T pop() {
        T e = null;
        if (!isEmpty()) {
            e = data[size - 1];
            size--;
        }
        return e;
    }

    /**
     * Obtiene el valor (sin extraer) del elemento que ocupa la cima de la pila
     * @return El elemento de la cima o Double.NEGATIVE_INFINITY si la pila está vacía
     */
    public T top() {
        T e = null;
        if (!isEmpty()) {
            e = data[size - 1];
        }
        return e;
    }

    /**
     * Determina si la pila está llena
     * Método de uso interno y por tanto privado ya que desde el punto de vista del
     * programador que utilice esta clase no tiene sentido, ya que la pila es dinámica,
     * es decir, crece automáticamente.
     * @return true si el array ha alcanzado su capacidad máxima o false en caso contrario
     */
    private boolean isFull() {
        return size == data.length;
    }

    /**
     * Determina si la pila está vacía
     * @return true si está vacía, false en caso contrario
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Devuelve el número de elementos que hay en la pila
     * @return Número de elementos de la pila
     */
    public int size() {
        return size;
    }


    public void clear(){
        size=0;
    }

    public Cola<T> clone(){
        Cola<T> copia = new Cola<>(this.data.length);
        for (int i = 0; i < this.size ; i++) {
            copia.add(this.data[i]);
        }
        return copia;
    }

    public T[] peek(int n){
        if (n > size){
            return null;
        }
        return Arrays.copyOfRange(data,size-n, size);
    }


    public int search(T element){
        for (int i = 0; i < size ; i++) {
            if (data[i].equals(element)){
                return i+1;
            }
        }
        return -1;
    }

    public void reverse(){
        for (int i = 0; i < size/2 ; i++) {
            T aux = data[i];
            data[i] = data[size-1-i];
            data[size-1-i]=aux;
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]).append(" ");
        }
        sb.append("]");
        return sb.toString();
    }
}
