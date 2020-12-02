
package modulo10.hilos;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Saludador2  implements Runnable{
        
    private int i  = 0;
    Logger logger = Logger.getLogger("Saludador2");

    @Override
    public void run() {
        // muestra por pantalla  20 holas
        while (i < 20){
            try {
                logger.info( Thread.currentThread().getName()
                        + "- hola " + i++);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Saludador2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//fin run 
   
}
    
    
    

