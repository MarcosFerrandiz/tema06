package com.marcosferrandiz.tema06.Ejercicio5;



public class Circunferencia {

    private punto centro;
    private double radio;

    public Circunferencia(punto centro, double radio) {
        this.centro = centro;
        this.radio = radio;
    }

    public Circunferencia(double x, double y, double radio){
        this.centro = new punto(x,y);
        this.radio = radio;
    }
    public Circunferencia(){
        this(new punto(), 1.0);
    }
    public punto getCentro() {
        return centro;
    }
    public void setCentro(punto centro) {
        this.centro = centro;
    }
    public double getRadio() {
        return radio;
    }
    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double distancia(punto punto){
        return this.centro.distancia(punto);
    }

    public double area(){
        return Math.PI * Math.pow(radio,2);
    }
    public double perimetro(){
        return 2 * Math.PI * radio;
    }

    @Override
    public String toString() {
        if (this.centro.getX() == 0 && this.centro.getY() == 0){
            return "Círcunferencia de radio"+ radio+ " cm situada en el origen de coordenadas";
        }
        return "Circunferencia{" + "centro=" + centro + ", radio=" + radio + '}';
    }
}
