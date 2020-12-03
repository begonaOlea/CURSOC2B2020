package modulo10.hilos.tratamiento;

import java.util.logging.Logger;

public class NumerosPares  implements Runnable{

    Logger log = Logger.getLogger("Pares");
    
    @Override
    public void run() {
        for(int i = 1 ; i <= 40; i++ ){
            if( i % 2 == 0) log.info(""+i); 
        }
    }//fin run
    
}
