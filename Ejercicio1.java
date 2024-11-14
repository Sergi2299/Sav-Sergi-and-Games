import java.util.Scanner;

public class Ejercicio1 { 
    public static int obtenerNumero(Scanner scanner) {
        boolean valido = false;
        int numero = 0;
        
        while (!valido) {
            //Dira que introduzca al usuario un número entero
            System.out.print("Inserte un número entero: ");
            String entrada = scanner.nextLine();
            //En caso de que ponga decimales, saltara el siguiente mensaje
            if (esDecimal(entrada)) {
                System.out.println("Los decimales no son válidos.");
                continue;
                //Si lo que pone el usuario es texto saltara otro mensaje de error
            } else if (esTexto(entrada)) {
                System.out.println("El texto no es válido, introduzca un número entero.");
                continue;
                //Si lo que pone no es un número entero, aparecera este error
            } else if (!entrada.matches("-?\\d+")) {
                System.out.println("Formato no válido. Inténtelo de nuevo.");
                continue;
            }
            
            try { 
                //Convierte en un número entero
                numero = Integer.parseInt(entrada);
                valido = true;
            } catch (NumberFormatException e) {
                //Si hay error, otro mensaje
                System.out.println("ERROR: Eso no es un número entero.");
            }
        }
        return numero;
    }
//Función que detectara si el número lleva decimal
    public static boolean esDecimal(String entrada) {
        return entrada.matches("-?\\d+[.,]\\d+");
    }
// Función para el texto
    public static boolean esTexto(String entrada) {
        return !entrada.matches("-?\\d+");
    }
//Para si el número es primo
    public static boolean esPrimo(int n) { 
        if (n <= 1) return false;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        } 
        return true; 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            //Para que introduzca el número entero 
            int numero = obtenerNumero(scanner);
            //En caso del que ponga sea primo, lo dira
            if (esPrimo(numero)) {
                System.out.println(numero + " es primo.");
            } else {
                //En caso de que sea primo, tambien
                System.out.println(numero + " no es número primo.");
            }
//Preguntara al usuario si quiere porbar otro numero para crear un bucle
            System.out.print("¿Quieres probar otro número? (si/no): ");
            String respuesta = scanner.nextLine().toLowerCase();

            if (respuesta.equals("no")) {
                continuar = false;
                System.out.println("¡Gracias por probarlo!");
            } else if (!respuesta.equals("si")) {
                System.out.println("No entendí la orden");
            }
        }
        //Aquí he cerrado el scanner
        scanner.close();
    }
}
