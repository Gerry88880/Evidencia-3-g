import java.util.ArrayList;
import java.util.List;

public class Estudiante implements Imprimible {
    private String nombre;
    private int edad;
    private List<Materia> materias;

    public Estudiante(String nombre, int edad) throws EdadInvalidaException {
        if (edad < 0) {
            throw new EdadInvalidaException("La edad no puede ser negativa.");
        }
        this.nombre = nombre;
        this.edad = edad;
        this.materias = new ArrayList<>();
    }

    public void agregarCalificacion(String nombreMateria, double calificacion) throws CalificacionInvalidaException {
        if (calificacion < 0 || calificacion > 10) {
            throw new CalificacionInvalidaException("La calificación debe estar entre 0 y 10.");
        }
        Materia materia = new Materia(nombreMateria, calificacion);
        materias.add(materia);
    }

    public double calcularPromedio() {
        double suma = 0;
        for (Materia materia : materias) {
            suma += materia.getCalificacion();
        }
        return materias.isEmpty() ? 0 : suma / materias.size();
    }

    public void imprimir() {
        System.out.println("Estudiante: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Promedio: " + calcularPromedio());
        System.out.println("Materias:");
        for (Materia materia : materias) {
            System.out.println("  " + materia.getNombreMateria() + ": " + materia.getCalificacion());
        }
    }
