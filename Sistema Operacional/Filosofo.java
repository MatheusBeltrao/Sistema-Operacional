class Filosofo extends Thread {

    private final Object garfoEsquerdo;
    private final Object garfoDireito;

    Filosofo(Object garfoEsquerdo, Object garfoDireito) {
        this.garfoEsquerdo = garfoEsquerdo;
        this.garfoDireito = garfoDireito;
    }

    private void acao(String acao) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " " + acao);
        Thread.sleep(((int) (Math.random() * 100)));
    }

    public void run() {
        try {
            while (true) {
                acao("Pensando");

                synchronized (garfoEsquerdo) {
                    acao("Pegou o garfo esquerdo");
                    synchronized (garfoDireito) {

                        acao("Pegou o garfo direito - comendo");
                        acao("Colocou o garfo direito");
                    }
                    acao("Colocou o garfo esquerdo. Voltou a pensar");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }
}
