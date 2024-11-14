import java.util.Scanner;

public class Mi_Partida {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("¿Quieres jugar una partida de dados? (si/no)");
        String respuesta = scanner.nextLine().toLowerCase();
//Verifica ña respuesta que le des para iniciar el programa
        while (!respuesta.equals("si") && !respuesta.equals("no")) {
            System.out.println("Respuesta no reconocida, por favor introduce 'si' o 'no':");
            respuesta = scanner.nextLine().toLowerCase();
        }

        if (respuesta.equals("si")) {
            //Para obtener el nombre de dichos jugadores
            String[] nombres = obtener_datos();
            Juego_Dados partida = new Juego_Dados(nombres[0], nombres[1]);
            partida.descripcion_juego();

            boolean continuar = true;
            //Es un bucle para que el juego continue si es que asi el usuario lo desea
            while (continuar) {
                boolean juegoActivo = true;
                while (juegoActivo) {
                    partida.jugar_ronda();
                    juegoActivo = !partida.hay_ganador();//Para saber si hay un ganador
                }

                System.out.println("¿Deseas jugar otra vez? (si/no)");
                respuesta = scanner.nextLine().toLowerCase();
                while (!partida.validarRespuesta(respuesta)) {
                    System.out.println("No entendí, por favor, introduce 'si' o 'no':");
                    respuesta = scanner.nextLine().toLowerCase();
                }
                continuar = respuesta.equals("si");//Es para seguir en caso de que la respuesta sea "si"
            }
        } else {
            System.out.println("Gracias por usar el programa, ¡nos vemos la próxima!");
        }
    }
//Es un metodo para obtener los nombres de dichos jugadores
    public static String[] obtener_datos() {
        String[] nombres = new String[2];
        for (int i = 0; i < 2; i++) {
            boolean nombreValido = false;
            while (!nombreValido) {
                System.out.println("Introduce el nombre del Jugador " + (i + 1) + ": ");
                String nombre = scanner.nextLine();
                //Validar que el nombre introducido con¡mience con letra y no pongas nada vacio
                if (nombre.length() >= 2 && nombre.length() <= 10 && Character.isLetter(nombre.charAt(0)) && !nombre.trim().isEmpty()) {
                    nombres[i] = nombre;
                    nombreValido = true;
                } else {
                    System.out.println("Nombre inválido. Debe tener entre 2 y 10 caracteres, comenzar con una letra y no estar vacío.");
                }
            }
        }
        return nombres;
    }
}