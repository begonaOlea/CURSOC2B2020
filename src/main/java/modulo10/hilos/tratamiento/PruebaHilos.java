package modulo10.hilos.tratamiento;

public class PruebaHilos {
    
    public static void main(String[] args) {
        
        NumerosPares np = new NumerosPares();
        Abecedario abc = new Abecedario();
        
        Thread h1 = new Thread(np);
        Thread h2 = new Thread(abc);
        
        h1.start();
        h2.start();
        
    }
    
}
