import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PistaEsqui {
    private int id;
    private int capacidadMaxima;
    private int esquiadoresActuales;
    private Lock lock;

    public PistaEsqui(int id, int capacidadMaxima) {
        this.id = id;
        this.capacidadMaxima = capacidadMaxima;
        this.esquiadoresActuales = 0;
        this.lock = new ReentrantLock();
    }

    public boolean acceder() {
        lock.lock();
        try {
            if (esquiadoresActuales < capacidadMaxima) {
                esquiadoresActuales++;
                System.out.println("Esquiador accedió a la pista " + id
                        + ". Esquiadores actuales: " + esquiadoresActuales);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return true;
            } else {
                System.out.println("Pista " + id
                        + " está llena. Esquiador no pudo acceder.");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return false;
            }
        } finally {
            lock.unlock();
        }
    }

    public void salir() {
        lock.lock();
        try {
            esquiadoresActuales--;
            System.out.println("Esquiador salió de la pista " + id
                    + ". Esquiadores actuales: " + esquiadoresActuales);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            lock.unlock();
        }
    }
}
