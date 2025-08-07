import java.util.*;
public class JuegoDado {
    private static Dado d1 = new Dado();
    private static Scanner sc = new Scanner(System.in);
    private static boolean comprobar = true;

    public static void juegoDado() {
        System.out.println(" ** JUEGO DEL DADO **");

        while (comprobar) {
            System.out.print("Presiona ENTER para tirar el dado o escribe 'salir' para terminar: ");
            String entrada = sc.nextLine();

            if (entrada.equalsIgnoreCase("salir")) {
                System.err.println("Saliendo del juego....");
                comprobar = false;
            } else {
                d1.lanzar();
                System.out.println("Ha salido el número " + d1.getNumero());
                d1.imprimir();
            }
        }
    }
}