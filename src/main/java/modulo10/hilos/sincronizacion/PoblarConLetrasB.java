package modulo10.hilos.sincronizacion;

public class PoblarConLetrasB  implements Runnable{

    //private MiPila p ;
    private MiPilaSincronizada p;
    
    public PoblarConLetrasB(MiPilaSincronizada p) {
        this.p = p;
    }

    @Override
    public void run() {
        for(int i = 0 ; i < 30; i++){
            p.push('B');
        }
    }//fin run
 
} //fin clase
