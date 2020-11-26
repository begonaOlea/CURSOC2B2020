
package com.shop;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PruebaGestionarTienda {
    
    public static void main(String[] args) {
        GestionarCafes service = new GestionarCafes();
        try {
            service.modificarVentas("Colombian", 75);
            
            service.modificarVentasPrepared("Espresso", 10);
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage()); 
        }
    }//fin main
}
