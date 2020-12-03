/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo10.hilos.sincronizacion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

/**
 *
 * @author begonaolea
 */
public class PruebaPilaNoThreadSafe {
    
    public static void main(String[] args) throws InterruptedException {
        
      MiPila pila = new MiPila();
      
      PoblarConLetrasA pA = new PoblarConLetrasA(pila);
      PoblarConLetrasB pB = new PoblarConLetrasB(pila);
      
      Thread h1 = new Thread(pA);
      Thread h2 = new Thread(pB);
      
      h1.start();
      h2.start();
      
      h1.join();
      h2.join();

      System.out.println("... pila tiene ");
      
      for(char c: pila.data){
          System.out.println(c);
      }
    }
    
}
