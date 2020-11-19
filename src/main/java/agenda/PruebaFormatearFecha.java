
package agenda;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class PruebaFormatearFecha {
    
    
    public static void main(String[] args) {
        
        Date f = new Date();
        
        
        DateFormat  df = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.SHORT);
        
        System.out.println("fecha " +  df.format(f));
   
        //Locale lEU = new Locale("es","ES");
        Locale lEU = new Locale("zh","HK");
        DateFormat  dfFR = DateFormat.getDateInstance(DateFormat.LONG, lEU);
       
         System.out.println("fecha " +  dfFR.format(f));
    }
    
    
}
