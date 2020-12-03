package modulo10.hilos.sincronizacion;

public class MiPila {

    int idx = 0;
    char[] data = new char[30];

    public void push(char c) {
        data[idx] = c;
        idx++;
    }
    
    public char pop() {
        idx--;
        return data[idx];
    }
     
    
}


