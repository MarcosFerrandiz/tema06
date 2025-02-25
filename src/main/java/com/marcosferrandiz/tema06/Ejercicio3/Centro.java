package com.marcosferrandiz.tema06.Ejercicio3;


import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

public class Centro {
    private int MAX_ALUMNOS = 99;
    private Alumno[] alumnos = new Alumno[MAX_ALUMNOS];

    /**
     * Crea un alumno nuevo con los parametros indicados, en el caso de que el NIA no este registrado devuelve true y lo crea, en el caso de que el NIA coincida devolvera false
     * @param nia NIA del alumno
     * @param nombre Nombre del alumno
     * @param apellidos Apellidos del alumno (1 o 2 o 7)
     * @param nacimiento Fecha de nacimiento del alumno
     * @param grupo Grupo al que pertenece el alumno
     * @param tel Telefono del alumno, padre o lo que sea
     * @return Devuelve true si se ha creado el usuario y false si no se ha podido crear, ya sea porque el NIA se repite o porque esta lleno
     */
    public boolean crearAlumno(int nia, String nombre, String apellidos, LocalDate nacimiento, String grupo, int tel){
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].getNia() == nia) {
                return false;
            }
        }
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] == null) {
                alumnos[i] = new Alumno(nia, nombre, apellidos, nacimiento, grupo, tel);
                return true;
            }
        }
        return false;
    }

    /**
     * Busca el NIA introducido y devuelve true si lo encuentra y false si no existe
     * @param nia NIA que debe de buscar
     * @return Devuelve true si ha encontrado el NIA y false si no existe el NIA ese
     */
    public boolean buscarNia(int nia){
        for (int i = 0; i < alumnos.length ; i++) {
            if (alumnos[i] != null && alumnos[i].getNia() == nia) {
                return true;
            }
        }
        return false;
    }

    /**
     * Da de baja a un alumno y te devuelve true si se ha hecho de forma correcta o false si no se ha podido hacer porque no existe nadie con el NIA
     * @param nia Es el NIA del alumno que queremos dar de baja
     * @return Devuelve true si se ha hecho de forma buena o false si no se podido realizar
     */
    public boolean bajaAlumno(int nia){
        for (int i = 0; i < alumnos.length ; i++) {
            if (alumnos[i] != null && alumnos[i].getNia() == nia) {
                alumnos[i] = null;
                return true;
            }
        }
        return false;
    }

    /**
     * Crea un array de tipo Alumno donde guardaremos los alumnos que estan en el grupo
     * @param grupo Es el grupo que queremos consultar
     * @return Devuelve un array de tipo Alumno en el cual estan los alumnos del grupo que buscamos
     */
    public Alumno[] alumnosPorGrupo(String grupo){
        int contador = 0;
        int posicionParaGrupo = 0;
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].getGrupo().equals(grupo)) {
                contador++;
            }
        }
        Alumno[] alumnosGrupo = new Alumno[contador];
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].getGrupo().equals(grupo)) {
                alumnosGrupo[posicionParaGrupo++] = alumnos[i];
            }
        }
        return alumnosGrupo;
    }

    public int edad(int index){
        return Period.between(alumnos[index].getNacimiento(), LocalDate.now()).getYears();
    }

    //No consigo hacer que funcione conio
    public Alumno[] alumnosPorEdad(int edad){
        int contador = 0;
        int posicionParaArrayEdad = 0;
        for (int i = 0; i < alumnos.length ; i++) {
            if (alumnos[i] != null && edad(i) == edad) {
                contador++;
            }
        }
        Alumno[] alumnosEdad = new Alumno[contador];
        for (int i = 0; i < alumnos.length ; i++) {
            if (alumnos[i] != null && edad(i) == edad);{
                alumnosEdad[posicionParaArrayEdad++] = alumnos[i];
            }
        }
        return alumnosEdad;
    }

    /**
     * Metodo que busca un alumno por su NIA
     * @param nia Es el NIA del alumno que estamos buscando
     * @return Devuelve un Array de Alumno con la informacion del alumno con el NIA, si no existe pues devuelve null
     */
    public Alumno[] alumnoPorNia(int nia){
        for (int i = 0; i < alumnos.length ; i++) {
            if (alumnos[i] != null && alumnos[i].getNia() == nia) {
                return new Alumno[]{alumnos[i]};
            }
        }
        return null;
    }

    public Alumno[] alumnoPorApellidos(String apellidos){
        int contador = 0;
        int posicionParaArrayApellidos = 0;
        for (int i = 0; i < alumnos.length ; i++) {
            if (alumnos[i] != null && alumnos[i].getApellidos().equals(apellidos)) {
                contador++;
            }
        }
        Alumno[] alumnosApellidos = new Alumno[contador];
        for (int i = 0; i < alumnos.length ; i++) {
            if (alumnos[i] != null && alumnos[i].getApellidos().equals(apellidos)) {
                alumnosApellidos[posicionParaArrayApellidos++] = alumnos[i];
            }
        }
        return alumnosApellidos;
    }

    @Override
    public String toString() {
        return "Centro{" +
                ", alumnos=" + Arrays.toString(alumnos) +
                '}';
    }
}
