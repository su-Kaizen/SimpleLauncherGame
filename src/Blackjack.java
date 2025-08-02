import java.util.*;

public class Blackjack {
    private Baraja baraja;
    private List<Carta> cartasJugador;
    private int puntuacionJugador;
    private int puntuacionDealer;
    private List<Carta> cartasDealer;
    public Blackjack(){
        baraja = new Baraja();
        cartasDealer = new ArrayList<>();
        cartasJugador = new ArrayList<>();
        baraja.remover();
        puntuacionDealer = 0;
        puntuacionJugador = 0;
    }

    public static void startGame(){
        Gestor.clear();
        String jugarDenuevo = "n";
        Blackjack b = new Blackjack();
        System.out.println("BLACKJACK\nTrata de llegar a 21 sin pasarte");
        System.out.println("Presiona enter para empezar a jugar.");
        Gestor.stringInput();
        System.out.println();

        do{
            b.cartasDealer.add(b.baraja.sacarPrimera());

            b.cartasJugador.add(b.baraja.sacarPrimera());
            b.cartasJugador.add(b.baraja.sacarPrimera());
            b.imprimirMesa();
            do{

                if(b.puntuacionJugador < 21){
                    int choice = b.imprimirOpciones();
                    if(choice == 1){
                        b.cartasJugador.add(b.baraja.sacarPrimera());
                    }
                    else{;
                        break;
                    }
                }
                Gestor.clear();
                b.imprimirMesa();
            }
            while(b.puntuacionJugador < 21);

            Gestor.clear();
            do{
                b.cartasDealer.add(b.baraja.sacarPrimera());
                b.imprimirMesa();
                Gestor.sleep(2);
                Gestor.clear();
            }
            while (b.puntuacionDealer < 17);
            b.imprimirMesa();
            b.comprobarGanador();

            System.out.println("\nJugar de nuevo?[S/n]");
            jugarDenuevo = Gestor.stringInput();
            if(jugarDenuevo.equalsIgnoreCase("s")){
               b = new Blackjack();
            }
            Gestor.clear();
        }
        while(jugarDenuevo.equalsIgnoreCase("s"));
    }



    public int imprimirOpciones(){
        System.out.println("[1] Pedir\n" +
                            "[2] Plantarte");
        return Gestor.intInput();
    }

    public void imprimirMesa(){

        System.out.println("+-----------------------------------------------------+");
        System.out.print("DEALER -> ");
        puntuacionDealer = 0;
        for(Carta c: cartasDealer){
            System.out.print(c+" ");
            puntuacionDealer += c.getValor();
        }
        System.out.println("| El dealer tiene "+puntuacionDealer+". "+(puntuacionDealer > 21 ? "Se ha pasado." : ""));

        System.out.print("JUGADOR -> ");
        puntuacionJugador = 0;
        for(Carta c: cartasJugador){
            System.out.print(c+" ");
            puntuacionJugador += c.getValor();
        }
        System.out.println("| Tienes "+puntuacionJugador+". " + (puntuacionJugador > 21 ? "Te has pasado." : ""));
        System.out.println("+-----------------------------------------------------+");
        System.out.println();
    }

    public void comprobarGanador(){
        puntuacionJugador = puntuacionJugador > 21 ? -1 : puntuacionJugador;
        puntuacionDealer = puntuacionDealer > 21 ? -1 : puntuacionDealer;
        if(puntuacionJugador > puntuacionDealer){
            System.out.println("Has ganado!!");
        }
        else if(puntuacionJugador < puntuacionDealer){
            System.err.println("Has perdido");
        }
        else{
            System.out.println("Empate.");
        }
    }
}
