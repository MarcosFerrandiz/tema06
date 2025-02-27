package com.marcosferrandiz.tema06.Ejercicio7;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

public class AtencionPaciente {
    private Pacientes[] pacientes;
    private final int id;
    private final LocalDateTime fechaEntrada;
    private final String sintomatología;
    private final double[] preRev;
    private final LocalDateTime fechaAlta;
    private final String motivoAlta;
    private final int TAMANO_MAXIMO;
    private int cantidadPacientes;


    public AtencionPaciente(int id, LocalDateTime fechaEntrada, String sintomatología, double[] preRev, LocalDateTime fechaAlta, String motivoAlta) {
        this.id = id;
        this.fechaEntrada = fechaEntrada;
        this.sintomatología = sintomatología;
        this.preRev = preRev;
        this.fechaAlta = fechaAlta;
        this.motivoAlta = motivoAlta;
        this.TAMANO_MAXIMO = 40;
        this.pacientes = new Pacientes[TAMANO_MAXIMO];
        this.cantidadPacientes = 0;
    }

    public int getCantidadPacientes() {
        return cantidadPacientes;
    }

    public int getId() {
        return id;
    }

    public Pacientes[] getPacientes() {
        return pacientes;
    }

    public LocalDateTime getFechaEntrada() {
        return fechaEntrada;
    }

    public String getSintomatología() {
        return sintomatología;
    }

    public double[] getPreRev() {
        return preRev;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public String getMotivoAlta() {
        return motivoAlta;
    }

    public void setPacientes(Pacientes[] pacientes) {
        this.pacientes = pacientes;
    }

    @Override
    public String toString() {
        return "AtencionPaciente{" +
                "pacientes=" + Arrays.toString(pacientes) +
                ", id=" + id +
                ", fechaEntrada=" + fechaEntrada +
                ", sintomatología='" + sintomatología + '\'' +
                ", preRev=" + Arrays.toString(preRev) +
                ", fechaAlta=" + fechaAlta +
                ", motivoAlta='" + motivoAlta + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AtencionPaciente that = (AtencionPaciente) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
