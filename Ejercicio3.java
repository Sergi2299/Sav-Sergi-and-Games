import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String respuesta;
        //Esta función es un bucle para el usuario  que quiera interactuar mas con el programa
        do {
            int importe = consultar_importe(); //Pide el importe
            calcular_pago(importe); //Es un calculo que muestra la cantidad de billetes y monedas
            System.out.print("Quieres hacer otra operacion? (si/no): ");
            respuesta = scanner.nextLine().trim().toLowerCase();
        } while (respuesta.equals("si"));// Se repite en el caso de que la respuesta sea "si"
        
        System.out.println("Gracias por confiar en nosotros"); //Mensaje que sale al darle que "no"
        scanner.close();
    }
//Solicita el importe correspondiente si el usuario desea retirar dinero
    public static int consultar_importe() {
        Scanner scanner = new Scanner(System.in);
        int importe = -1;
//Es un bucle por si   el usuario no introduze un importe válido, en este caso uno mayor a 0
        while (importe <= 0) {
            System.out.print("Cuanto quieres sacar? (mayor a 0): ");
            if (scanner.hasNextInt()) { 
                importe = scanner.nextInt();
                if (importe <= 0) {
                    System.out.println("Ese importe no vale. Intenta otra vez.");
                }
            } else {
                System.out.println("Eso no es un numero. Intenta otra vez.");
                scanner.next(); //Descarta algo no válido
            }
        }
        return importe;
    }
//Este metodo calcula y muestra la cantidad de billetes y monedas que te entregara
    public static void calcular_pago(int importe) {
        int[] billetes = {500, 200, 100, 50, 20, 10, 5};
        int[] monedas = {2, 1};
        int cantidad;

        System.out.println("Aqui tienes tus billetes y monedas: ");
        //Calcula y muestra billetes necesarios en el importe
        for (int billete : billetes) {
            cantidad = importe / billete;
            if (cantidad > 0) {
                System.out.println("Billetes de " + billete + "€: " + cantidad);
                importe %= billete; //Actualiza el importe que queda
            }
        }
//Muestra las monedas necesaria para el resto del importe
        for (int moneda : monedas) {
            cantidad = importe / moneda;
            if (cantidad > 0) {
                System.out.println("Monedas de " + moneda + "€: " + cantidad);
                importe %= moneda;
            }
        }
//Se encarga de informar que no puede seguir distribuyendo en billetes y monedas
        if (importe > 0) {
            System.out.println("Queda un total de " + importe + "€ que no se puede sacar en billetes y monedas.");
        }
    }

    @Override
    public String toString() {
        return "Ejercicio3 []";
    }
}