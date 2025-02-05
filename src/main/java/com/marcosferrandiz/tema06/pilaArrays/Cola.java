package com.marcosferrandiz.tema06.pilaArrays;

public class Cola {
    private static final double ERROR = Double.NEGATIVE_INFINITY;
    private static final int INITIAL_SIZE = 10;
    private static final float GROW_FACTOR = 2f;
    private static double[] data;
    private static int size;

    public Cola() {
        this(INITIAL_SIZE);
    }

    /**
     * Crea una pila de tamaño inicial recibido como parámetro
     * @param size Capacidad inicial de la pila
     */
    public Cola(int size) {
        data = new double[size];
        this.size = 0;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    private boolean isFull() {
        return size == data.length;
    }

    private void expand() {
        double[] aux = new double[Math.round(data.length * GROW_FACTOR)];
        for (int i = 0; i < data.length; i++) {
            aux[i] = data[i];
        }
        data = aux;
    }

    public void push(double e) {
        if (isFull()) {
            expand();
        }
        data[size] = e;
        size++;
    }

    public void moveToLeft(){
        for (int i = 0; i < data.length -1 ; i++) {
            data[i] = data[i+1];
        }
    }

    public double pop() {
        double e = ERROR;
        if (!isEmpty()) {
            e = data[0];
            size--;
            moveToLeft();
        }
        return e;
    }

    public double peek() {
        double e = ERROR;
        if (!isEmpty()) {
            e = data[0];
        }
        return e;
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
