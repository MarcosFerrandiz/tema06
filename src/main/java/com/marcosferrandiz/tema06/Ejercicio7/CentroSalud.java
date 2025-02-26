package com.marcosferrandiz.tema06.Ejercicio7;

import java.time.LocalDateTime;

public class CentroSalud {
    private final int TAMANO_MAXIMO;
    private Pacientes[] pacientes;
    private Pacientes[] pacientesAtendiendose;
    private int cantidadPacientes;
    private int cantidadPacientesAtendiendose;

    public CentroSalud() {
        this.TAMANO_MAXIMO = 40;
        this.pacientes = new Pacientes[TAMANO_MAXIMO];
        this.pacientesAtendiendose = new Pacientes[TAMANO_MAXIMO];
    }

    public boolean crearPaciente(int sip, String nombre, Pacientes.Sexo genero, int edad, LocalDateTime fechHoraLlegada, String sintomas, PreRev[] preRev ){

        if (comprobarSipSiExiste(sip)){
            return false;
        }

        if(cantidadPacientes < TAMANO_MAXIMO){
            pacientes[cantidadPacientes] = new Pacientes(sintomas,fechHoraLlegada,edad,genero,nombre,sip,preRev);
            cantidadPacientes++;
            return true;
        }
        else{
            return false;
        }
    }

    public boolean comprobarSipSiExisteEnAtender(int sip){
        for (int i = 0; i < cantidadPacientesAtendiendose ; i++) {
            if (pacientesAtendiendose.equals(sip)){
                return true;
            }
        }
        return false;
    }
    public boolean comprobarSipSiExisteEnEspera(int sip){
        for (int i = 0; i < cantidadPacientes ; i++) {
            if (pacientes.equals(sip)){
                return true;
            }
        }
        return false;
    }

    public boolean comprobarSipSiExiste(int sip){
        if (comprobarSipSiExisteEnEspera(sip) || comprobarSipSiExisteEnAtender(sip)){
            return true;
        }
        return false;
    }


    public boolean cambiarHoraLlegada(int sip){
        for (int i = 0; i < cantidadPacientes ; i++) {
            if (pacientes[i].getSip() == sip){
                pacientes[i].setFechHoraLlegada(LocalDateTime.now());
                return true;
            }
        }
        return false;
    }

    public boolean atenderPaciente(int sip){
        if (!comprobarSipSiExiste(sip)){
            return false;
        }

        for (int i = 0; i < cantidadPacientes ; i++) {
            if (pacientes[i].equals(sip)){
                pacientesAtendiendose[cantidadPacientesAtendiendose++] = pacientes[i];
                pacientes[i] = null;
                arreglarArraySinAtenderMoviendoNulls();
                return true;
            }
        }
        return false;

    }

    public void arreglarArraySinAtenderMoviendoNulls(){
        int posicionNUeva = 0;
        for (int i = 0; i < cantidadPacientes ; i++) {
            if (pacientes[i] !=null){
                pacientes[posicionNUeva] = pacientes[i];
                posicionNUeva++;
            }
        }
        for (int i = posicionNUeva; i < pacientes.length ; i++) {
            pacientes[i] = null;
        }
    }





}
