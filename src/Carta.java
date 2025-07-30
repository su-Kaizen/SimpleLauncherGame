public class Carta {
    private Palo palo;
    private Valor valor;
    private int valorInt;
    private String simbolo;
    private String color;

    public Carta(Valor v, Palo p) {
        valor = v;
        palo = p;

        switch (valor) {
            case V2 -> valorInt = 2;
            case V3 -> valorInt = 3;
            case V4 -> valorInt = 4;
            case V5 -> valorInt = 5;
            case V6 -> valorInt = 6;
            case V7 -> valorInt = 7;
            case V8 -> valorInt = 8;
            case V9 -> valorInt = 9;
            case A -> valorInt = 11;
            default -> valorInt = 10; /*El resto de cartas (10, J, Q, K) valen 10*/
        }

        switch (palo){
            case CORAZONES -> {color = "\033[0;31m"; simbolo = "♥";}
            case DIAMANTES -> {color = "\033[0;31m"; simbolo = "♦";}
            case TREBOLES -> {simbolo = "♠";}
            case PICAS -> {simbolo = "♣";}
        }
    }

    @Override
    public String toString(){
        String v = valor+"";
        v = v.replace("V","");
        return color+simbolo+v+"\033[0m";
    }

    public int getValor(){
        return valorInt;
    }

    public Palo getPalo(){
        return palo;
    }
}

enum Valor {V2, V3, V4, V5, V6, V7, V8, V9, V10, J, Q, K, A}

enum Palo {CORAZONES, DIAMANTES, TREBOLES, PICAS}