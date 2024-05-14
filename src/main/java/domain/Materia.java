package domain;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Materia {
    private String nombre;
    private Integer anioCursada;
    private List<Materia> materiasCorrelativas;

    public Materia(String nombre, Materia ... materias) {
        this.nombre = nombre;
        this.materiasCorrelativas = new ArrayList<>();
        Collections.addAll(materiasCorrelativas, materias);
    }

    public void agregarMateriasCorrelativas(Materia ... materiasCorrelativas){
        Collections.addAll(this.materiasCorrelativas, materiasCorrelativas);
    }

    public List<Materia> getMateriasCorrelativas() {
        return materiasCorrelativas;
    }
}
