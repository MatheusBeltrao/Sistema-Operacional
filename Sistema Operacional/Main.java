public class Main {

    public static void main(String[] args) throws Exception {

        final Filosofo[] filosofos = new Filosofo[5];
        Object[] garfos = new Object[filosofos.length];

        for (int i = 0; i < garfos.length; i++) {
            garfos[i] = new Object();
        }
        for (int i = 0; i < filosofos.length; i++) {

            Object garfoEsquerdo = garfos[i];
            Object garfoDireito = garfos[(i + 1) % garfos.length];

            if (i == filosofos.length - 1) {

                filosofos[i] = new Filosofo(garfoDireito, garfoEsquerdo);
            } else {
                filosofos[i] = new Filosofo(garfoEsquerdo, garfoDireito);
            }
            Thread t = new Thread(filosofos[i], "Filósofo " + (i + 1));
            t.start();
        }
    }
}
