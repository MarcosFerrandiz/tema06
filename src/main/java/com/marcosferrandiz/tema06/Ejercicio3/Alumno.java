package com.marcosferrandiz.tema06.Ejercicio3;

public class Alumno {
    private int nia;
    private String nombre;
    private String apellidos;
    private String nacimiento;
    private String grupo;
    private int tel;

    public Alumno(int nia, String nombre, String apellidos, String nacimiento, String grupo, int tel) {
        this.nia = nia;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacimiento = nacimiento;
        this.grupo = grupo;
        this.tel = tel;
    }

    public int getNia() {
        return nia;
    }

    public void setNia(int nia) {
        this.nia = nia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nia=" + nia + ", nombre='" + nombre + '\'' + ", apellidos='" + apellidos + '\'' + ", nacimiento='" + nacimiento + '\'' + ", grupo='" + grupo + '\'' + ", tel=" + tel + '}';
    }

}
