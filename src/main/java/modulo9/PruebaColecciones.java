
package modulo9;

import java.util.ArrayList;

public class PruebaColecciones {
    
    public static void main(String[] args) {
       
        //ARRAY 
        // 1. admiten tipos primitivos y objetos
        // 2. al crearlo debo indicar el tamaño y no cambia nunca
        // 3. al añadir un nuevo elementos hay que indiar posición valida
        int[] notas; //declaración
        notas = new int[5]; //instancio el array
        notas[0] = 34; //añadir entero
        
        for(int n : notas){
            System.out.println(n);
        }
        
        //ver tamaño
        System.out.println( notas.length );
        
        //COLECCION ARRAYLIST
        // 1. solo admiten objetos
        // 2. crea una colección que admite todos los elementos que quieras
        // 3. permite añadir elementos a la coleccion sin tener que 
        //    preocuparse de la posicion
        ArrayList<Integer> notasList; //declaración
        notasList = new ArrayList<Integer>();
        
        System.out.println(" vacio? " + notasList.isEmpty());
        
        notasList.add(34);   // notasList.add(new Integer(34));
        System.out.println("tamaño " + notasList.size());
        
        for(Integer i : notasList){
            System.out.println(i);
        }
        
        notasList.add(45);
        System.out.println("tamaño " + notasList.size());
        
        System.out.println("ESta el numero 34 ? " + notasList.contains(34));
       
        notasList.remove(new Integer(45));
        notasList.remove(new Integer(34));
        System.out.println("tamaño " + notasList.size());
        System.out.println("vacio " + notasList.isEmpty());
        
    }//fin main
    
}
