import java.util.*;

public class Baraja {
    private List<Carta> b;

    public Baraja() {
        b = new ArrayList<>();
        crearBaraja();
    }

    private void crearBaraja() {
        Palo[] p = new Palo[]{Palo.PICAS, Palo.DIAMANTES, Palo.TREBOLES, Palo.CORAZONES};
        Valor[] v = new Valor[]{Valor.V2, Valor.V3, Valor.V4, Valor.V5, Valor.V6, Valor.V7,
                Valor.V8, Valor.V9, Valor.V10, Valor.J, Valor.Q, Valor.K, Valor.A};

        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < v.length; j++) {
                b.add(new Carta(v[j],p[i]));
            }
        }
    }


    public void remover(){
        // Se remueve la baraja 2 veces
        Collections.shuffle(b);
        Collections.shuffle(b);
    }

    public void imprimir(){
        int cont = 0;
        System.out.println();
        for(int i = 0; i<b.size(); i++){
            System.out.print(b.get(i)+" ");
            cont ++;
            if(cont == 13){
                System.out.println();
                cont = 0;
            }
        }
        System.out.println();
    }

    public Carta sacarRandom(){
        Random r = new Random();
        int randomIndex = r.nextInt(0,b.size());
        return b.remove(randomIndex);
    }

    public Carta sacarPrimera(){
        return !b.isEmpty() ? b.removeFirst() : null;
    }
}
