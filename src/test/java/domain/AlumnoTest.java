package domain;

import org.junit.Assert;
import org.junit.Test;

public class AlumnoTest {

    private Materia analisis1 = new Materia("Analisis matematico 1");
    private Materia algebra = new Materia("Algebra y geometria analitica");
    private Materia analisis2 = new Materia("Analisis matematico 2", analisis1, algebra);


    @Test
    public void alumnoConMateriasPreviasPuedeCursarMateriaConCorrelativas() {
        Alumno alumno = new Alumno("208.822-8");
        alumno.agregarMateriasAprobadas(analisis1, algebra);

        Assert.assertTrue(alumno.puedeCursar(analisis2));
    }

    @Test
    public void alumnoSinMateriasNoPuedeCursarMateriaConCorrelativas() {
        Alumno alumno = new Alumno("208.822-8");

        Assert.assertFalse(alumno.puedeCursar(analisis2));
    }
}
