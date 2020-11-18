package modulo9;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class PruebasColeccionesSet {

    public static void main(String[] args) {

        //NO PERMITE DUPLICADOS
        // 1. HASHSET  -      no ordenado
        // 2. LINKEDHASHSET   por orden de insercción
        // 3. TREESET  -      ordenado
        Set<String> nombres = new TreeSet<String>();
        //new LinkedHashSet<String>();
        //new HashSet<String>();

        nombres.add("Carlos");
        nombres.add("Andres");
        nombres.add("Ramiro");
        nombres.add("Pablo");
        nombres.add("Pablo");
        nombres.add("Ramiro");

        for (String nombre : nombres) {
            System.out.println(nombre);
        }
        /*
        HashSet:        LinkedHashSet:     TreeSet
            Andres          Carlos              Andres
            Pablos          Andres              Carlos 
            Carlos          Raniroo             Pablo
            Ramiro          Pablo               Ramiro
         */

    }//fin

}
