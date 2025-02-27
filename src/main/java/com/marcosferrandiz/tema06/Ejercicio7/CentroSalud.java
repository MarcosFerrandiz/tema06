package com.marcosferrandiz.tema06.Ejercicio7;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

public class CentroSalud {
    private final int TAMANO_MAXIMO;
    private Pacientes[] pacientes;
    private int cantidadPacientes;

    public CentroSalud() {
        this.TAMANO_MAXIMO = 40;
        this.pacientes = new Pacientes[TAMANO_MAXIMO];
        this.cantidadPacientes = 0;
    }

    public int getCantidadPacientes() {
        return cantidadPacientes;
    }

    public Pacientes[] getPacientes() {
        return pacientes;
    }

    public void crearPaciente(int sip, String nombre, Pacientes.Sexo genero, LocalDate fechaNacimiento){
            pacientes[cantidadPacientes] = new Pacientes(sip,nombre,genero,fechaNacimiento);
            cantidadPacientes++;
    }


    public boolean atenderPaciente(int sip,CentroSalud centroSalud,double[] preRev){
        for (int i = 0; i < cantidadPacientes ; i++) {
            if (centroSalud.getPacientes()[i].getSip() == sip && !centroSalud.getPacientes()[i].isAtendido() ){
                for (int j = 0; j < preRev.length ; j++) {
                    centroSalud.getPacientes()[i].getPreRev()[j] = preRev[j];
                    centroSalud.getPacientes()[i].setAtendido(true);
                }
                return true;
            }
        }
        return false;
    }

    public boolean darAltaMedica(int sip, String motivoAlta){

    }

    @Override
    public String toString() {
        return "CentroSalud{" +
                ", pacientes=" + Arrays.toString(pacientes) +
                '}';
    }
}
