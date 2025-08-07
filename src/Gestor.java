import java.io.IOException;
import java.util.*;
public class Gestor {

    public static Scanner sc = new Scanner(System.in);

    public void menu(){
        int opcion = 0;

        do{
            System.out.println(" -- SimpleLauncherGame --");
            System.out.println("Elige un juego: ");
            System.out.println("1. Adivina el número");
            System.out.println("2. Piedra papel o tijera");
            System.out.println("3. 3 en raya");
            System.out.println("4. Blackjack (21)");
            System.out.println(" 5. Dado");
            System.out.println("0. Salir del programa");
            opcion = Gestor.intInput();

            switch (opcion){
                case 0 -> System.err.println("Saliendo del programa...");
                case 1 -> AdivinaNumeroJuego.adivinar();
                case 2 -> PiedraPapelTijeraJuego.juego();
                case 3 -> TicTacToe.startGame();
                case 4 -> Blackjack.startGame();
                case 5 -> JuegoDado.juegoDado();
                default -> System.out.println("Introduce una opción válida");
            }

            // Salto de linea para dejar un espacio
            System.out.println();
        } while (opcion != 0);
    }

    // Este metodo es el equivalente al nextLine, en un futuro si queremos modificarlo lo haremos por aqui
    public static String stringInput(){
        System.out.print("> "); // Imprimos esto para que el usuario sepa que tiene que escribir algo

        // Hago el trim para que si el usuario escribe accidentalmente espacios al principo o al final, los ignore
        return sc.nextLine().trim();
    }

    // Lo mismo que el metodo de arriba pero para enteros
    public static int intInput() {
        System.out.print("> ");
        int input = sc.nextInt();
        sc.nextLine();

        return input;
    }


    // Comando paa borrar la terminar (No funciona si lo ejecutas desde el IDE)
    public static void clear(){
        try {
            if(System.getProperty("os.name").contains("Windows")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else{
                new ProcessBuilder("clear").start();
            }
        }
        catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static void sleep(int s){
        long l = s* 1000;
        try{
            Thread.sleep(l);
        }
        catch (InterruptedException ex){
            ex.printStackTrace();
        }

    }
}
