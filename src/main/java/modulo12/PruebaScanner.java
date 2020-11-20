
package modulo12;

import java.util.Locale;
import java.util.Scanner;

public class PruebaScanner {
    public static void main(String[] args) {
        
        String linea = "1#Luis Ramos#23.0";
        
        Scanner sc = new Scanner(linea); // usa el locale del sistema es , 
        sc.useDelimiter("#");
        sc.useLocale(Locale.US);
        
        int id = sc.nextInt();
        String nombre = sc.next();
        double tasa = sc.nextDouble();
        
        System.out.printf("id %d nombre %s tasa %08.2f", id, nombre, tasa);
        
    }
}
