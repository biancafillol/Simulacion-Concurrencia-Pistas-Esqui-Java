public class AccesoSki {
    public static void main(String[] args) {
        CentroEsqui centro = new CentroEsqui(5, 10);

        Runnable esquiador = () -> {
            int pistaId = (int) (Math.random() * 5);
            if (centro.accederPista(pistaId)) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                centro.salirPista(pistaId);
            }
        };

        Thread[] threads = new Thread[50];
        for (int i = 0; i < 50; i++) {
            threads[i] = new Thread(esquiador);
            threads[i].start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
