import java.util.HashMap;
import java.util.Map;

public class CentroEsqui {
    private Map<Integer, PistaEsqui> pistas;

    public CentroEsqui(int numPistas, int capacidadMaximaPorPista) {
        pistas = new HashMap<>();
        for (int i = 0; i < numPistas; i++) {
            pistas.put(i, new PistaEsqui(i, capacidadMaximaPorPista));
        }
    }

    public boolean accederPista(int pistaId) {
        PistaEsqui pista = pistas.get(pistaId);
        if (pista != null) {
            return pista.acceder();
        } else {
            System.out.println("Pista " + pistaId + " no existe.");
            return false;
        }
    }

    public void salirPista(int pistaId) {
        PistaEsqui pista = pistas.get(pistaId);
        if (pista != null) {
            pista.salir();
        } else {
            System.out.println("Pista " + pistaId + " no existe.");
        }
    }
}

