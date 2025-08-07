import java.util.Random;

public class Dado {
    private int numero;

    public void lanzar() {
        Random random = new Random();
        this.numero = random.nextInt(6) + 1;
    }

    public int getNumero() {
        return this.numero;
    }

    public void imprimir() {
        String[][] caras = {
                {
                        "---------",
                        "|       |",
                        "|   ●   |",
                        "|       |",
                        "---------"
                },
                {
                        "---------",
                        "| ●     |",
                        "|       |",
                        "|     ● |",
                        "---------"
                },
                {
                        "---------",
                        "| ●     |",
                        "|   ●   |",
                        "|     ● |",
                        "---------"
                },
                {
                        "---------",
                        "| ●   ● |",
                        "|       |",
                        "| ●   ● |",
                        "---------"
                },
                {
                        "---------",
                        "| ●   ● |",
                        "|   ●   |",
                        "| ●   ● |",
                        "---------"
                },
                {
                        "---------",
                        "| ●   ● |",
                        "| ●   ● |",
                        "| ●   ● |",
                        "---------"
                }
        };

        for (String linea : caras[numero - 1]) {
            System.out.println(linea);
        }
    }
}
