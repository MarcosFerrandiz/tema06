package com.marcosferrandiz.tema06.pilaArrays.Ejercicio7;

public class Hospital {
    private ColaConsulta[] consultas;
    private final int CANT_COL_CONS = 5;
    public Hospital(){
        consultas = new ColaConsulta[CANT_COL_CONS];

        for (int i = 0; i < CANT_COL_CONS ; i++) {
            Medicos medico = new Medicos("DR. "+ (char) ('A'+i),String.format("%06d",i+1));
            consultas[i] = new ColaConsulta(medico);

            for (int j = 0; j < CANT_COL_CONS ; j++) {
                Paciente paciente = new Paciente("Paciente "+(i * 2 + j * 3),String.format("%08d%C", (i * 20 + j * 3), (char) ('A'+j)));
                consultas[i].anadirPaciente(paciente);
            }
        }
    }

    public ColaConsulta[] getConsultas(){
        return consultas;
    }

    public void mostrarColas(){
        for (int i = 0; i < consultas.length ; i++) {
            System.out.println("Consulta "+ (i+1) +": "+consultas[i]);
        }
    }
}
