import java.util.*;
public class Gestor {

    public static Scanner sc = new Scanner(System.in);

    public void menu(){
        int opcion = 0;

        do{
            System.out.println(" -- SimpleLauncherGame --");
            System.out.println("Elige un juego: ");
            System.out.println("1. Adivina el número");
            System.out.println("0. Salir del programa");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 0 -> System.err.println("Saliendo del programa...");
                case 1 -> AdivinaNumeroJuego.adivinar();
                default -> System.out.println("Introduce una opción válida");
            }
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

}
