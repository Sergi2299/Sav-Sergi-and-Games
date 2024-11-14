import java.util.Scanner;

public class Ejercicio4 {
//Le pedira una frase al usuario
    public static String solicitar_frase() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Escribe la primera frase de tu libro favorito: ");//Leera la frase completa
            String frase = scanner.nextLine();
            System.out.println("Tu frase es: " + frase);
            return frase;//Devolvera dicha frase
        }
    }
//Sirve para mostrar y contar el número de palabras en la frase introducida
    public static void contar_palabras(String frase) {
        String[] palabras = frase.split(" "); //La divide en palabras
        System.out.println("La frase tiene " + palabras.length + " palabras.");
    }

//Muestra el metodo  del número de letras en las frases
    public static void contar_letras(String frase) {
        int cantidadLetras = 0;
        for (char letra : frase.toCharArray()) {
            if (Character.isLetter(letra)) {
                cantidadLetras++;
            }
        }
        System.out.println("Hay " + cantidadLetras + " letras en la frase.");
    }
//Cuenta las vocales de cada frase y las muestra
    public static void contar_vocales(char[] caracteres) {
        int contadorPalabrasConVocales = 0;
        String frase = new String(caracteres);

        for (String palabra : frase.split(" ")) {
            int cantidadVocales = 0;
            if (palabra.matches(".*[aeiouAEIOU].*")) {
                contadorPalabrasConVocales++;
                //Cuenta las vocales por palabras
                for (char letra : palabra.toCharArray()) {
                    if (String.valueOf(letra).matches("[aeiouAEIOU]")) {
                        cantidadVocales++;
                    }
                }
                System.out.println("Palabra: " + palabra + ", Vocales: " + cantidadVocales);
            }
        }
        //Para mostrar el número total de palabras que tiene al menos una vocal
        System.out.println("Total de palabras con al menos una vocal: " + contadorPalabrasConVocales);
    }
// Es el metodo principal
    public static void main(String[] args) {
        String frase = solicitar_frase();// Le dira al usuario que introduzca una frase
        contar_palabras(frase); //Se dedica a contar y mostrar el número de palabras
        contar_letras(frase);//Cuenta y muestra el número de letras
        char[] caracteres = frase.toCharArray();//Transforma la frase array 
        contar_vocales(caracteres);//Muestra las vocales por palabra
    }
}

