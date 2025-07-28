import java.util.Scanner;
public class AdivinaNumeroJuego {
    public static Scanner sc = new Scanner(System.in);
    public static void adivinar(){
        int intentosJugador;
        int intentosRestantes = 5;
        boolean resultado = false;

        System.out.println("**  ADIVINA EL NÚMERO  **");

        System.out.println("Introduce el valor mínimo del rango: ");
        int min = Gestor.intInput();

        System.out.println("Introduce el valor máximo del rango: ");
        int max = Gestor.intInput();

        while (max <= min){
            System.out.println("El valor máximo debe de ser mayor que el mínimo. Inténtalo de nuevo");
            System.out.println("Introduce el valor máximo del rango: ");
            max = Gestor.intInput();
        }

        int numeroSecreto = (int) (Math.random() * (max - min +1)) + min;

        System.out.println("!Intenta adivinar el número entre " + min + " y " + max + "!");
        System.out.println("Tienes 5 intentos");

        while (intentosRestantes > 0 && resultado == false){
            System.out.print("Intento (" + (6 - intentosRestantes) + "/5): ");
            intentosJugador = Gestor.intInput();
            intentosRestantes--;
            if (intentosJugador < numeroSecreto){
                System.out.println("El número es más alto");
            } else if (intentosJugador > numeroSecreto) {
                System.out.println("El número es más bajo");
            } else{
                System.out.println("¡Correcto! Has adivinado el número");
                resultado = true;
            }
        }

        if (resultado == false){
            System.out.println("Te has quedado sin intentos. El número secreto era el: "+ numeroSecreto);
        }
    }
}
