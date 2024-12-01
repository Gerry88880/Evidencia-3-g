public class Materia {
    private String nombreMateria;
    private double calificacion;

    public Materia(String nombreMateria, double calificacion) {
        this.nombreMateria = nombreMateria;
        this.calificacion = calificacion;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public double getCalificacion() {
        return calificacion;
    }
}
