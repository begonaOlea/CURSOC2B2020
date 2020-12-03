package modulo10.hilos.tratamiento;

import java.util.logging.Logger;

public class Abecedario  implements Runnable{

    Logger log = Logger.getLogger("Abecedarios");
    
    @Override
    public void run() {
        for(char i = 'A' ; i <= 'Z'; i++ ){
             log.info(""+i); 
        }
    }//fin run
    
}
