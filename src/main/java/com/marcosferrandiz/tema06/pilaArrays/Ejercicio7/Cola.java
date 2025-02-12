package com.marcosferrandiz.tema06.pilaArrays.Ejercicio7;


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


    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(data, size));
    }
}
