package modulo9.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author begonaolea
 */
public class PruebaAPICollections {

    public static void main(String[] args) {

        ArrayList<Alumno> lista = new ArrayList<Alumno>();

        //Collections.sort(List)
        //Collections.sort(List , Comparator)
        /*
        1.  Añadri alumnos a la lista
        2.  Recorrer el array
        3.  Ordenar  con sort por su compareto  (dni)
        4.  Recorrer el array
        5.  Ordenar por  ciclo y luego por dni  - Craer un Comparator
        6.  Recorrer
         */
        lista.add(new Alumno(33, "Lucas", Ciclo.PRIMARIA));
        lista.add(new Alumno(213, "Laura", Ciclo.ESO));
        lista.add(new Alumno(123, "Roberto", Ciclo.ESO));
        lista.add(new Alumno(563, "Ramiro", Ciclo.PRIMARIA));

        System.out.println("Ver lista:");
        for(Alumno a: lista){
            System.out.println(a);
        }
        
        // ordenar por DNI
        System.out.println("Ordenar por dni");
        Collections.sort(lista);
        for(Alumno a: lista){
            System.out.println(a);
        }
        
        //ordenar por ciclo y dni
        System.out.println(" Ordenar por ciclo y dni");
        Collections.sort(lista, new ComparadorAlumnoPorCicloDNI());
        for(Alumno a: lista){
            System.out.println(a);
        }
   
    }//fin main

   
    
}//fin clase

class ComparadorAlumnoPorCicloDNI implements Comparator<Alumno>{

    @Override
    public int compare(Alumno a1, Alumno a2) {
       //comparo ciclo
       if(a1.getCiclo().ordinal() == a2.getCiclo().ordinal()){
            return a1.getDni() - a2.getDni(); 
       }else{
           return a1.getCiclo().ordinal() - a2.getCiclo().ordinal();
       }
        
    }//fin copare
    
}
