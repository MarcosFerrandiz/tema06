package com.marcosferrandiz.tema06;

public class jugador {
    private String nombre;
    private float portero;
    private float defensa;
    private float pase;
    private float regate;
    private float tiro;
    private float estadoForma;

    public jugador(String nombre, float portero, float defensa, float pase, float regate, float tiro, float estadoForma){
        this.nombre = nombre;
        this.portero = portero;
        this.defensa = defensa;
        this.pase = pase;
        this.regate = regate;
        this.tiro = tiro;
        this.estadoForma = estadoForma;
    }

    public jugador(String nombre) {
        this(nombre, 50, 50, 50, 50, 50, 50);
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "portero=" + portero +
                ", defensa=" + defensa +
                ", pase=" + pase +
                ", regate=" + regate +
                ", tiro=" + tiro +
                ", estadoForma=" + estadoForma +
                '}';
    }

    public static void main(String[] args) {
        jugador futbolista1 = new jugador("Alexia Putellas", 29, 81, 80, 83, 84, 90);
        System.out.println(futbolista1);
    }

}
