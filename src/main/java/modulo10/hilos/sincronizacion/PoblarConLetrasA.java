package modulo10.hilos.sincronizacion;


public class PoblarConLetrasA  implements Runnable{

    private MiPilaSincronizada p ;

    public PoblarConLetrasA(MiPilaSincronizada p) {
        this.p = p;
    }

    @Override
    public void run() {
        for(int i = 0 ; i < 30; i++){
            p.push('A');
        }
    }//fin run
 
} //fin clase
