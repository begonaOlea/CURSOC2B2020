package modulo10.hilos.sincronizacion;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MiPilaSincronizada {

    int idx = 0;
    char[] data = new char[60];

    public void push(char c) {
        synchronized (this) {
            try {
                data[idx] = c;
                Thread.sleep(20);
                idx++;
            } catch (InterruptedException ex) {
                Logger.getLogger(MiPilaSincronizada.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public char pop() {
        synchronized (this) {
            idx--;
            return data[idx];
        }
    }

}
