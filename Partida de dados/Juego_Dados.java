import java.util.Random;

class Juego_Dados {
    private final String jugador1;//Nombre del jugador 1
    private final String jugador2;//Nombre del jugador 2
    private int puntuacion1;// La puntuación del jugador 1
    private int puntuacion2;// La puntuación del jugador 2
    private int rondasGanadas1;//Las rondas conscutiva ganadas por el jugador 1
    private int rondasGanadas2;//Las rondas conscutiva ganadas por el jugador 2
    private final int PUNTOS_OBJETIVO = 10;//Los puntos requeridos para ganar
    private final int RONDAS_SEGUIDAS_OBJETIVO = 5;//Las rondas necesarias para ganar
    private final Random random = new Random();//Generara números aleatorios
//Para construir la clase en este caso Juego_Dados
    public Juego_Dados(String jugador1, String jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.puntuacion1 = 0;
        this.puntuacion2 = 0;
        this.rondasGanadas1 = 0;
        this.rondasGanadas2 = 0;
    }
// Estan son las reglas del juego
    public void descripcion_juego() {
        System.out.println("Sean bienvenidos a esta partida de dados. Las normas son las siguientes:");
        System.out.println("El jugador que ganará será el que consiga 5 rondas seguidas o 10 puntos.");
        System.out.println("Cada jugador deberá lanzar dos dados por ronda, y se otorgarán puntos según las coincidencias.");
        System.out.println("Si en cualquier par de dados resulta haber coincidencia, Jugador 1 obtendrá un punto.");
        System.out.println("Si no hay coincidencias al lanzar los dados, Jugador 2 obtendrá doble puntuación.");
        System.out.println("Que comience el juego.");
    }
//Es el metodo donde se lanzan los dados
    public void jugar_ronda() {
        int dado1Jugador1 = random.nextInt(6) + 1;//Dado 1 del jugador 1
        int dado2Jugador1 = random.nextInt(6) + 1;//Dado 2 del jugador 1
        int dado1Jugador2 = random.nextInt(6) + 1;//Dado 1 del jugador 2
        int dado2Jugador2 = random.nextInt(6) + 1;//Dado 1 del jugador 2
//Comprueba si coinciden los dados lanzados
        boolean coincidencia = dado1Jugador1 == dado2Jugador1 || dado1Jugador2 == dado2Jugador2 ||
                               dado1Jugador1 == dado1Jugador2 || dado2Jugador1 == dado2Jugador2;
//Se encarga de ajustar las rondas y puntos en función de sus coincidencias
        if (coincidencia) {
            puntuacion1++;
            rondasGanadas1++;
            rondasGanadas2 = 0;
        } else {
            puntuacion2 += 2;
            rondasGanadas2++;
            rondasGanadas1 = 0;
        }
//Muestra los resultados de las rondas actuales
        System.out.println(jugador1 + " lanzó " + dado1Jugador1 + " y " + dado2Jugador1);
        System.out.println(jugador2 + " lanzó " + dado1Jugador2 + " y " + dado2Jugador2);
        System.out.println("Puntuación actual: " + jugador1 + ": " + puntuacion1 + ", " + jugador2 + ": " + puntuacion2);
    }
//Para saber quien ha ganado la partida
    public boolean hay_ganador() {
        if (rondasGanadas1 >= RONDAS_SEGUIDAS_OBJETIVO || puntuacion1 >= PUNTOS_OBJETIVO) {
            System.out.println(jugador1 + " ha ganado la partida");
            return true;
        }
        if (rondasGanadas2 >= RONDAS_SEGUIDAS_OBJETIVO || puntuacion2 >= PUNTOS_OBJETIVO) {
            System.out.println(jugador2 + " ha ganado la partida");
            return true;
        }
        return false;
    }
//Verifica si la respuesta  es "si " o "no"
    public boolean validarRespuesta(String respuesta) {
        return respuesta.equalsIgnoreCase("si") || respuesta.equalsIgnoreCase("no");
    }
}


