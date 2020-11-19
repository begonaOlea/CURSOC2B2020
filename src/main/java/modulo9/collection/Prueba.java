/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo9.collection;

import java.util.Date;

/**
 *
 * @author begonaolea
 */
public class Prueba {
    
    public static void main(String[] args) throws InterruptedException {
        
        Date f1 = new Date();
        Thread.sleep(20000);
        Date f2 = new Date();
        
        System.out.println(f1);
        System.out.println(f2);
        
        System.out.println(f1.compareTo(f2));
        
    }
    
}
