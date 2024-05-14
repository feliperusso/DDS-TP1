package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alumno {
    private String nombre, apellido, legajo;
    private List<Materia> materiasAprobadas;

    public Alumno(String legajo) {
        this.legajo = legajo;
        this.materiasAprobadas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void agregarMateriasAprobadas(Materia ... materiasAprobadas){
        Collections.addAll(this.materiasAprobadas, materiasAprobadas);
    }

    public Boolean puedeCursar(Materia materia){
        return this.materiasAprobadas.containsAll(materia.getMateriasCorrelativas());
    }
}

