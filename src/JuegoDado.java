import java.util.Scanner;

public class JuegoDado {
    private static Dado d1;
    private static Scanner sc;
    private static boolean comprobar = true;

    public JuegoDado(){
        d1 = new Dado();
        sc = new Scanner(System.in);
    }

    public static void juegoDado(){
        System.out.println(" ** JUEGO DEL DADO **");

        while (comprobar){
            System.out.println("Presiona ENTER para tirar el dado o escribe 'salir' para terminar: ");
            String entrada = sc.nextLine();

            if (entrada.equalsIgnoreCase("salir")){
                System.err.println("Saliendo del juego....");
                comprobar = false;
            } else{
                d1.lanzar();
                System.out.println("Ha salido el número " + d1.getNumero());
                d1.imprimir();
            }
        }
    }
}
