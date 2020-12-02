
package modulo10.hilos;


public class HiloPrueba2 {
    
  public static void main(String[] args) {
        
        System.out.println("... inicio");
        //creo Runnable
        Saludador2 s = new Saludador2();
        
        //creo hilo
        Thread h1 = new Thread(s);
        //inicio hilo
        h1.start();
        // h1.run();
        
        Thread h2 = new Thread(s);
         h2.start();
       // h2.run();
      

        System.out.println("... fin");
        
    }//fin main
}
