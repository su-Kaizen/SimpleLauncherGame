import java.util.*;
public class Gestor {

    Scanner sc = new Scanner(System.in);

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
                case 1 -> System.out.println();
                default -> System.out.println("Introduce una opción válida");
            }
        } while (opcion != 0);
    }
}
