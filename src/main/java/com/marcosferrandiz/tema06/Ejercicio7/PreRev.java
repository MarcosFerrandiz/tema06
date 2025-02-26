package com.marcosferrandiz.tema06.Ejercicio7;

public class PreRev {
    private final double temp;
    private final int ppm;
    private final int tenSis;
    private final int tenDias;

    public PreRev(double temp, int ppm, int tenSis, int tenDias) {
        this.temp = temp;
        this.ppm = ppm;
        this.tenSis = tenSis;
        this.tenDias = tenDias;
    }

    public double getTemp() {
        return temp;
    }

    public int getPpm() {
        return ppm;
    }

    public int getTenSis() {
        return tenSis;
    }

    public int getTenDias() {
        return tenDias;
    }
}
