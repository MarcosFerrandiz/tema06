package com.marcosferrandiz.tema06.generics;


import java.util.Arrays;

public class Cola<T> {
    private final static int DEFAULT_CAPACITY = 5;
    private final static float GROW_FACTOR = 2f;
    private T[] data;
    private int size;

    public Cola(T[] data, int size) {
        this.data = data;
        this.size = size;
    }

    public Cola() {this(DEFAULT_CAPACITY); }

    public Cola(int capacity){
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[capacity];
        data = temp;
        size = 0;
    }

    public boolean add(T value){
        if (isFull())
            expand();
        data[size]=value;
        size++;
        return true;
    }
    private boolean isFull(){
        return size== data.length;
    }
    private void expand(){
        @SuppressWarnings("unchecked")
        T[] copy = (T[]) new Object[Math.round(data.length*GROW_FACTOR)];
        for (int i = 0; i < size ; i++) {
            copy[i] = data[i];
        }
        data = copy;
    }

    public T remove(){
        if (isEmpty())
            return null;
        else {
            T e = data[0];
            size--;
            moveToLeft();
            return e;
        }
    }

    private void moveToLeft(){
        for (int i = 0; i < data.length-1; i++) {
            data[i] = data[i+1];
        }
    }


    public T peek() {
        return data[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void clear(){
        T[] vacio = (T[]) new Object[DEFAULT_CAPACITY];
        data = vacio;
        size=0;
    }

    public Cola<T> clone(){
        Cola<T> copia = new Cola<>(this.data.length);
        for (int i = 0; i < this.size ; i++) {
            copia.add(this.data[i]);
        }
        return copia;
    }

    public T peekLast(){
        if (isEmpty()){
            return null;
        }
        return data[size-1];
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
        return Arrays.toString(Arrays.copyOf(data, size));
    }
}