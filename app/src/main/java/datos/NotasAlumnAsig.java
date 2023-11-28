package datos;

import java.io.Serializable;

public class NotasAlumnAsig implements Serializable {
    private String nombreAlumno;
    private String asignatura;
    private double notaExamen;
    private double notaActividades;
    private double notaFinal;

    public NotasAlumnAsig(String nombreAlumno, String asignatura, double notaExamen, double notaActividades, double notaFinal) {
        this.nombreAlumno = nombreAlumno;
        this.asignatura = asignatura;
        this.notaExamen = notaExamen;
        this.notaActividades = notaActividades;
        this.notaFinal = notaFinal;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public double getNotaExamen() {
        return notaExamen;
    }

    public double getNotaActividades() {
        return notaActividades;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public boolean esIgual(String nombre, String asignatura) {
        return this.nombreAlumno.equals(nombre) && this.asignatura.equals(asignatura);
    }

    public void modificarNota(double notaExamen, double notaActividades, double notaFinal) {
        this.notaExamen = notaExamen;
        this.notaActividades = notaActividades;
        this.notaFinal = notaFinal;
    }
}
