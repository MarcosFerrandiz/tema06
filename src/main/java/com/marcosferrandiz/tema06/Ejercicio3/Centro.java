package com.marcosferrandiz.tema06.Ejercicio3;


import java.time.LocalDate;
import java.util.Arrays;

public class Centro {
    private int MAX_ALUMNOS = 99;
    private Alumno[] alumnos = new Alumno[MAX_ALUMNOS];

    public boolean crearAlumno(int nia, String nombre, String apellidos, LocalDate nacimiento, String grupo, int tel){
        for (int i = 0; i < alumnos.length ; i++) {
            if ( alumnos[i] != null && alumnos[i].getNia() == nia){
                System.out.println("Test");
            }else {
                for (int j = 0; i < alumnos.length  ; i++) {
                    if (alumnos[j] == null){
                        alumnos[j] = new Alumno(nia, nombre, apellidos, nacimiento, grupo, tel);
                        System.out.println("Test2");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Centro{" +
                ", alumnos=" + Arrays.toString(alumnos) +
                '}';
    }
}
