
package modulo10.hilos;

import java.util.logging.Logger;

public class Saludador implements Runnable{
    
    Logger logger = Logger.getLogger("Saludador");

    @Override
    public void run() {
        // muestra por pantalla  20 holas
        for(int i = 0 ; i < 20 ; i++){
          logger.info( Thread.currentThread().getName() 
                       + "- hola " + i);
        }
    }//fin run 
}
