package domain;

import org.junit.Assert;
import org.junit.Test;

public class InscripcionTest {

    private Materia analisis1 = new Materia("Analisis matematico 1");
    private Materia algebra = new Materia("Algebra y geometria analitica");
    private Materia analisis2 = new Materia("Analisis matematico 2", analisis1, algebra);

    @Test
    public void inscripcionConUnaMateriaSinCorrelativas () {
        Alumno alumno = new Alumno("208.822-8");
        Inscripcion inscripcion = new Inscripcion(alumno);

        inscripcion.agregarMaterias(analisis1);

        Assert.assertTrue(inscripcion.aprobada());
    }

    @Test
    public void inscripcionConMateriasSinCorrelativas () {
        Alumno alumno = new Alumno("208.822-8");
        Inscripcion inscripcion = new Inscripcion(alumno);

        inscripcion.agregarMaterias(analisis1, algebra);

        Assert.assertTrue(inscripcion.aprobada());
    }

    @Test
    public void inscripcionConMateriaConCorrelativasYAlumnoCumpleCorrelativas(){
        Alumno alumno = new Alumno("208.822-8");
        alumno.agregarMateriasAprobadas(analisis1, algebra);
        Inscripcion inscripcion = new Inscripcion(alumno);

        inscripcion.agregarMaterias(analisis2);

        Assert.assertTrue(inscripcion.aprobada());
    }

    @Test
    public void inscripcionConMateriaConCorrelativasYAlumnoNoCumpleCorrelativas(){
        Alumno alumno = new Alumno("208.822-8");
        alumno.agregarMateriasAprobadas(analisis1);
        Inscripcion inscripcion = new Inscripcion(alumno);

        inscripcion.agregarMaterias(analisis2);

        Assert.assertFalse(inscripcion.aprobada());
    }

    @Test
    public void inscripcionConMateriaConCorrelativasYalumnoSinMateriasAprobadas(){
        Alumno alumno = new Alumno("208.822-8");
        Inscripcion inscripcion = new Inscripcion(alumno);

        inscripcion.agregarMaterias(analisis2);

        Assert.assertFalse(inscripcion.aprobada());
    }
}
