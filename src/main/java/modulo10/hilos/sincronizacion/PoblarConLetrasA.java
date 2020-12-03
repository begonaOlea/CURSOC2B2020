package modulo10.hilos.sincronizacion;


public class PoblarConLetrasA  implements Runnable{

    private MiPila p ;

    public PoblarConLetrasA(MiPila p) {
        this.p = p;
    }

    @Override
    public void run() {
        for(int i = 0 ; i < 10; i++){
            p.push('A');
        }
    }//fin run
 
} //fin clase
