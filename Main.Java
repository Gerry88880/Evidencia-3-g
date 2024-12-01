import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Universidad universidad = new Universidad();

        while (true) {
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Agregar materia a un estudiante");
            System.out.println("3. Mostrar estudiantes y materias");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (opcion) {
                    case 1:

                        System.out.print("Nombre del estudiante: ");
                        String nombreEstudiante = scanner.nextLine();
                        System.out.print("Edad del estudiante: ");
                        int edadEstudiante = scanner.nextInt();
                        scanner.nextLine();
                        try {
                            Estudiante estudiante = new Estudiante(nombreEstudiante, edadEstudiante);
                            universidad.agregarEstudiante(estudiante);
                            System.out.println("Estudiante agregado correctamente.");
                        } catch (EdadInvalidaException e) {
                            System.out.println("Error al agregar estudiante: " + e.getMessage());
                        }
                        break;

                    case 2:

                        System.out.print("Nombre del estudiante: ");
                        String nombreEst = scanner.nextLine();
                        try {
                            Estudiante est = universidad.getEstudiante(nombreEst);
                            System.out.print("Nombre de la materia: ");
                            String nombreMateria = scanner.nextLine();
                            System.out.print("Calificación: ");
                            double calificacionMateria = scanner.nextDouble();
                            scanner.nextLine();
                            try {
                                est.agregarCalificacion(nombreMateria, calificacionMateria);
                                System.out.println("Materia agregada correctamente.");
                            } catch (CalificacionInvalidaException e) {
                                System.out.println("Error al agregar calificación: " + e.getMessage());
                            }
                        } catch (EstudianteNoEncontradoException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 3:

                        universidad.imprimir();
                        break;

                    case 4:

                        System.out.println("Saliendo...");
                        return;

                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Entrada inválida. Por favor, ingrese un número.");
                scanner.nextLine();
            }
        }
    }
}
