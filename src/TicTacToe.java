import java.util.Arrays;
import java.util.Random;

public class TicTacToe {
    private String[][] tablero;
    private int[] c;
    public static final String BLUE = "\033[0;34m";
    public static final String RED = "\033[0;31m";
    public static final String END = "\033[0m";

    public TicTacToe() {
        tablero = new String[][]{{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
        c = new int[2];
    }

    public static void startGame() {
        TicTacToe t = new TicTacToe();
        int posicion = 0;
        boolean valido = false;

        System.out.println("##3 EN RAYA##");
        t.pintarTablero();
        System.out.println("Empezar? [S/n]");
        String choice = Gestor.stringInput();

        if (choice.equalsIgnoreCase("s")) {
            /*
             * -1 = empate
             * 0 = en juego
             * 1 = jugador gana
             * 2 = bot gana
             * */
            int winner = 0;
            int jugadas = 1;
            do {

                // juega el usuario
                do {
                    System.out.println("Elige posición: ");
                    posicion = Gestor.intInput();

                    valido = t.comprobarPosicion(posicion);

                    if (valido) {
                        t.ponerFicha("X");
                    } else {
                        System.err.println("Porfavor introduzca una coordenada valida y vacia...");
                    }
                }
                while (!valido);

                // Comprobamos si hay ganador ya, solo se hace cuando hay mas 3 o mas jugadas (antes es imposible)
                if (jugadas >= 3) {
                    winner = t.comprobarGanador("X", jugadas);
                }

                if (winner == 0) {
                    // Ponemos la validez de nuevo el false
                    valido = false;

                    // juega el bot
                    do {
                        valido = t.comprobarPosicion(t.posicionRandom());

                        if (valido) {
                            t.ponerFicha("0");
                        }
                    }
                    while (!valido);

                    t.pintarTablero();

                    if (jugadas >= 3) {
                        winner = t.comprobarGanador("0", jugadas);
                    }
                }

                jugadas++;
            }
            while (winner == 0);
            t.pintarTablero();
            if(winner == -1){
                System.out.println("Empate.");
            }
            else if(winner == 1){
                System.out.println("HAS GANADO!");
            }
            else{
                System.err.println("Has perdido...");
            }
        }
    }


    public boolean comprobarPosicion(int pos) {
        pos = pos - 1;
        int x = 0;

        // Si la posicion esta fuera de esos rangos directamente es una posicion invalida
        if (pos > 9 || pos < 0) {
            return false;
        }

        // Sacando la posicion horizontal y vertical
        sacarPosicion(pos);

        // Si no tiene ni X ni 0 es que es libre, por lo tanto devolverá true
        return !this.tablero[c[0]][c[1]].equals("X") && !this.tablero[c[0]][c[1]].equals("0");
    }

    public void sacarPosicion(int pos) {
        int x = 0;
        while (pos - 3 >= 0) {
            pos = pos - 3;
            x++;
        }
        c[0] = x;
        c[1] = pos;
    }

    public void ponerFicha(String ficha) {
        tablero[c[0]][c[1]] = ficha;
    }

    public int posicionRandom() {
        Random r = new Random();
        return r.nextInt(1, 10);
    }

    public int comprobarGanador(String ficha, int jugadas) {
        int cont = 0;
        // Comprobacion horizontal
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j].equalsIgnoreCase(ficha)) {
                    cont++;
                } else {
                    break;
                }
            }
            if (cont == 3) {
                return ficha.equals("X") ? 1 : 2;
            }

            cont = 0;
        }

        // Comprobacion vertical
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[j][i].equalsIgnoreCase(ficha)) {
                    cont++;
                } else {
                    break;
                }
            }
            if (cont == 3) {
                return ficha.equals("X") ? 1 : 2;
            }
            cont = 0;
        }

        // Comprobacion en diagonal

        // En un sentido
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i][i].equals(ficha)) {
                cont++;
            } else {
                break;
            }
        }

        if (cont == 3) {
            return ficha.equals("X") ? 1 : 2;
        }

        cont = 0;

        // En otroo
        int x = 0;
        for (int i = 2; i >= 0; i--) {
            if (tablero[i][x].equals(ficha)) {
                cont++;
            } else {
                break;
            }
            x++;
        }

        if (cont == 3) {
            return ficha.equals("X") ? 1 : 2;
        }



        return jugadas == 5 ? -1 : 0;
    }


    // este metodo se encarga unicamente de pintar el tablero
    public void pintarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            System.out.print("+---+---+---+\n|");
            for (int j = 0; j < tablero[i].length; j++) {
                String value = tablero[i][j];
                if (value.equals("X")) {
                    value = BLUE + value + END;
                } else if (value.equals("0")) {
                    value = RED + value + END;
                }

                System.out.print(" " + value + " |");
            }
            System.out.println();
        }
        System.out.println("+---+---+---+");
    }
}
