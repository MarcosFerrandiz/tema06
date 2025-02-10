package com.marcosferrandiz.tema06.pilaArrays.Ejercicio7;


public class ColaConsulta {
    private Medicos medico;
    private Cola<Paciente> colaPacientes;

    public ColaConsulta(Medicos medico) {
        this.medico = medico;
        this.colaPacientes = new Cola<>();
    }

    public Medicos getMedico() {
        return medico;
    }

    public Cola<Paciente> getColaPacientes() {
        return colaPacientes;
    }

    public void añadirPaciente(Paciente paciente) {
        colaPacientes.add(paciente);
    }

    public Paciente atenderPaciente() {
        return colaPacientes.remove();
    }

    @Override
    public String toString() {
        return medico.toString() + "\nPacientes en espera: " + colaPacientes.toString();
    }

}
