package com.marcosferrandiz.tema06.pilaArrays.Ejercicio7;

import java.util.LinkedList;
import java.util.Queue;

public class Cola<T> {
    private Queue<T> cola;

    public Cola() {
        cola = new LinkedList<>();
    }

    public void add(T elemento) {
        cola.add(elemento);
    }

    public T remove() {
        return cola.poll();
    }

    public T peek() {
        return cola.peek();
    }

    public boolean isEmpty() {
        return cola.isEmpty();
    }

    public int size() {
        return cola.size();
    }

    @Override
    public String toString() {
        return cola.toString();
    }
}
