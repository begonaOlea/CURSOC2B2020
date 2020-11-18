package modulo9;

import java.util.ArrayList;
import java.util.List;

public class PruebasColeccionesList {
    
    public static void main(String[] args) {
        
        List<String> nombresList = new ArrayList<String>();
        
        nombresList.add("Maria");
        nombresList.add("Laura");
        nombresList.add("Amparo");
        
        System.out.println("Monstrar la segunda " + 
                nombresList.get(1));
        
        nombresList.add("Amparo"); //permite duplicados
        
        System.out.println(".... listar");
        for(String nombre : nombresList){
            System.out.println(nombre);
        }
        
        System.out.println("... añado otro en la posicion 7");
        
        nombresList.add(4,"Rosa");
        
          System.out.println(" añadir en medio");
        
        nombresList.add(1,"Belén");
        
        System.out.println(".... listar");
        for(String nombre : nombresList){
            System.out.println(nombre);
        }
        
      
        
        
    }//fin main
    
}
