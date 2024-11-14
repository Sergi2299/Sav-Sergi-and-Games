import java.util.ArrayList;
import java.util.List;

public class Ejercicio2 {


    public static void main(String[] args) {
        //Son diferentes calculos que realiza sobre los estudiantes
        CalcularMediaSuspensos();
        ContarSuspensosPorAsignatura();
        AlumnosQueHanAprobado();
        CalcularMediaAlumnos();
    
    }

 
    public static void ContarSuspensosPorAsignatura() { //Esta funcón dice cuantos estudiantes suspendieron cada asignatura
        int[] suspensos = new int[asignaturas.length];

        for (Object[] alumno : alumnos) {
            for (int i = 1; i < alumno.length; i++) {
                if ((int) alumno[i] < 5) { //Obviamente si la nota es menor a 5, esta suspendido
                    suspensos[i - 1]++;
                }
            }
        }

        for (int i = 0; i < asignaturas.length; i++) {
            System.out.println(asignaturas[i] + " ha sido suspendida por " + suspensos[i] + " alumnos.");
        }
    }

        //Esto es para calcular la media de los suspendidos en todas las asignaturas

    public static void CalcularMediaSuspensos() {
        int totalSuspensos = 0;
        int totalAsignaturas = 0;
        //Dice el total de suspensos y asignaturas

        for (Object[] alumno : alumnos) {
            for (int i = 1; i < alumno.length; i++) {
                if ((int) alumno[i] < 5) {
                    totalSuspensos++;
                }
                totalAsignaturas++;
            }
        }
        //Calcula las medias de los suspensos

        double mediaSuspensos = (double) totalSuspensos / totalAsignaturas;
        System.out.println("La media de suspensos de todos los estudiantes es " + mediaSuspensos);
    }

    //Dice las medias de los alumnos junto a sus asignaturas
    public static void CalcularMediaAlumnos() {
        for (Object[] alumno : alumnos) {
            double suma = 0;
            String nombre = (String) alumno[0];
            //Es la suma de las notas de cada asignatura/estudiante
            for (int i = 1; i < alumno.length; i++) {
                suma += (int) alumno[i];
            }
            //Muestra y calcula la media de los estudiantes
            double media = suma / (alumno.length - 1);
            System.out.println(nombre + " la media es: " + media);
        }
    }
//Método para clasificar los aprobados en todas las asignturas
    public static void AlumnosQueHanAprobado() {
        List<String> aprobados = new ArrayList<>();
// Comprueba si cada estudiante aprobo las asignaturas
        for (Object[] alumno : alumnos) {
            boolean haAprobado = true;
            double suma = 0;
            for (int i = 1; i < alumno.length; i++) {
                if ((int) alumno[i] < 5) {
                    haAprobado = false;
                    break; //Encuentra los suspensos y para de verificar el resto
                }
                suma += (int) alumno[i];
            }
            double media = suma / (alumno.length - 1);
            if (haAprobado && media >= 5) {
                aprobados.add((String) alumno[0]);
            }
        }
            //Hace una lista de estudiantes si aprobaron todas las asignaturas y su correspondiente media

        if (!aprobados.isEmpty()) {
            System.out.println("Los estudiantes que han aprobado son: " + String.join(", ", aprobados));
        } else {
            System.out.println("Ningún estudiante ha aprobado el curso.");
        }
    }
//Es la lista de las asignaturas

    static String[] asignaturas = {"HTML/CSS", "JavaScript", "Base de datos", "Programación"};

    static Object[][] alumnos = { // Salen las notas y cada asignatura
        {"Francisco", 9, 4, 8, 3},
        {"Lucía", 7, 8, 10, 5},
        {"Juan", 10, 8, 6, 8},
        {"Alba", 8, 5, 6, 5},
        {"Paula", 7, 4, 8, 4}
    };
}

