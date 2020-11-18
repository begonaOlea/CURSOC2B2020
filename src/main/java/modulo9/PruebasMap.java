
package modulo9;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;


public class PruebasMap {
    
    public static void main(String[] args) {
        
        // MAP  -  clave / valor 
        // HashMap  no hay ningun orden   -- 
        // LinkedHashMap    por orden de insercion
        // TreeMap          por orden natural
        Map<String, Double> notas = new TreeMap<String, Double> ();
                //new LinkedHashMap<String, Double> ();
                //new HashMap<String, Double> ();
        
        //Añadir elementos
        notas.put("Laura", 5.6);
        notas.put("Roberto", 9.6);
        notas.put("Roberto", 9.5);
        notas.put("Alberto", 8.5);
        
        System.out.println("La nota de Roberto es " + notas.get("Roberto"));
        
        //mostrar notas por alumno
        Set<String> keys = notas.keySet(); // HashSet
        for(String key : keys){
            System.out.println(key + " nota: " + notas.get(key));
        }
        
        
       Set<Entry<String,Double>> entradas = notas.entrySet();
       for(Entry e : entradas){
           System.out.println(e.getKey() + " - " + e.getValue());
       }
        
        
    }//fin main
    
}
