package modulo10.hilos.sincronizacion;

public class PoblarConLetrasB  implements Runnable{

    private MiPila p ;

    public PoblarConLetrasB(MiPila p) {
        this.p = p;
    }

    @Override
    public void run() {
        for(int i = 0 ; i < 10; i++){
            p.push('B');
        }
    }//fin run
 
} //fin clase
