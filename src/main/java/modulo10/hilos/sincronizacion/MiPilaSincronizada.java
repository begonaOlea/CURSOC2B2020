package modulo10.hilos.sincronizacion;

public class MiPilaSincronizada {

    int idx = 0;
    char[] data = new char[30];

    public void push(char c) {
        synchronized (this) {
            data[idx] = c;
            idx++;
        }
    }

    public char pop() {
        synchronized (this) {
            idx--;
            return data[idx];
        }
    }

}
