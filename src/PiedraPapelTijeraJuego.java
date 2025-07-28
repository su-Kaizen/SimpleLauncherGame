public class PiedraPapelTijeraJuego {

    public void juego(){
        String[] opciones = {"piedra, papel, tijera"};

        System.out.println("**  PIEDRA PAPEL TIJERA  **");

        System.out.println("Elige (piedra, papel o tijera): ");
        String eleccion = Gestor.stringInput().toLowerCase();

        while (!eleccion.equals("piedra") && !eleccion.equals("papel") && !eleccion.equals("tijera")){
            System.out.println("Valor incorrecto. Elija piedra, papel o tijera: ");
            eleccion = Gestor.stringInput().toLowerCase();
        }

        int maquina = (int) (Math.random() *3);

        // Este String representa que si sale un 0 es piedra, 1 papel y 2 es tijera
        String eleccionMaquina = opciones[maquina];

        System.out.println("La máquina eligió: "+ eleccionMaquina);

        if (eleccion.equals(eleccionMaquina)){
            System.out.println("¡Empate!");
        } else if (
            (eleccion.equals("piedra") && eleccionMaquina.equals("tijera")) ||
            (eleccion.equals("papel") && eleccionMaquina.equals("piedra")) ||
            (eleccion.equals("tijera") && eleccionMaquina.equals("papel"))
        ) {
            System.out.println("¡Ganaste!");
        } else{
            System.out.println("¡Perdiste!");
        }
    }

}
