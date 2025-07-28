import java.util.Arrays;

public class TicTacToe {
    private String[][] tablero;
    private int[] c;
    public static final String BLUE = "\033[0;34m";
    public static final String RED = "\033[0;31m";
    public static final String END = "\033[0m";

    public TicTacToe(){
        tablero = new String[][]{{"1","2","3"},{"4","5","6"},{"7","8","9"}};
        c = new int[2];
    }

    public static void startGame(){
        TicTacToe t = new TicTacToe();
        int posicion = 0;
        boolean valido = false;

        System.out.println("##3 EN RAYA##");
        t.pintarTablero();
        System.out.println("Empezar? [S/n]");
        String choice = Gestor.stringInput();

        if(choice.equalsIgnoreCase("s")){
            /*
            * -1 = empate
            * 0 = en juego
            * 1 = jugador gana
            * 2 = bot gana
            * */
            int winner = 0;

            do{
                // juega el usuario
                do{
                    System.out.println("Elige posición: ");
                    posicion = Gestor.intInput();

                    valido = t.comprobarPosicion(posicion);

                    if(valido){
                        t.ponerFicha("X");
                    }
                    else{
                        System.out.print("\n Porfavor introduzca una coordenada valida y vacia...");
                    }
                }
                while(!valido);

                t.pintarTablero();

            }
            while(winner == 0);
        }
    }


    public boolean comprobarPosicion(int pos){
        pos = pos-1;
        int x = 0;

        // Si la posicion esta fuera de esos rangos directamente es una posicion invalida
        if(pos > 9 || pos < 0){
            return false;
        }

        // Sacando la posicion horizontal y vertical
        sacarPosicion(pos);

        // Si no tiene ni X ni 0 es que es libre, por lo tanto devolverá true
        return !this.tablero[c[0]][c[1]].equals("X") && !this.tablero[c[0]][c[1]].equals("0");
    }

    public void sacarPosicion(int pos){
        int x = 0;
        while(pos-3 >= 0){
            pos = pos - 3;
            x ++;
        }
        c[0] = x;
        c[1] = pos;
    }


    public void ponerFicha(String ficha){
        tablero[c[0]][c[1]] = ficha;
    }

    public void pintarTablero(){
        for(int i = 0; i<tablero.length; i++){
            System.out.print("+---+---+---+\n|");
            for(int j = 0; j<tablero[i].length; j++){
                String value = tablero[i][j];
                if(value.equals("X")){
                    value = BLUE+value+END;
                }
                else if(value.equals("0")){
                    value = RED+value+END;
                }

                System.out.print(" "+value+" |");
            }
            System.out.println();
        }
        System.out.println("+---+---+---+");
    }
}
