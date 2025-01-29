package com.marcosferrandiz.tema06.Ejercicio5;

public class punto {
    private double x;
    private double y;

    public punto(double x, double y){
        this.x = x;
        this.y = y;
    }

    public punto(){
        this.x = 0;
        this.y = 0;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distancia(punto otroPunto){
        double distx = this.x - otroPunto.getX();
        double disty = this.y - otroPunto.getY();
        return Math.sqrt(distx * distx + disty * disty);
    }

    @Override
    public String toString() {
        return "punto{" + "x=" + x + ", y=" + y + '}';
    }
}
