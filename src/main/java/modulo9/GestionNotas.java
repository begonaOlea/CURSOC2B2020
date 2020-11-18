package modulo9;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GestionNotas {
      
    public static void crearListaAsistenciaAlumnos(Set<Alumno> alumnos){
        System.out.println("  LISTADO DE ASISTENCIA ");
        for(Alumno a : alumnos){
            System.out.println(a.getDni() + "  " + a.getNombre());
        }
        System.out.println("...............................");
    }
       
    public static void main(String[] args) {
        
       // HashSet<Alumno> lista = new HashSet<Alumno>();
        TreeSet<Alumno> lista = new TreeSet<Alumno>(); // ordenado 
        lista.add(new Alumno(3, "Alberto"));
        lista.add(new Alumno(1, "Luis"));
        lista.add(new Alumno(2, "Mario"));
        lista.add(new Alumno(1, "Luis")); // añade 
        lista.add(new Alumno(4, "Maria"));
        
        GestionNotas.crearListaAsistenciaAlumnos(lista);
        
        TreeSet<Alumno> lista2 
                = new TreeSet<Alumno>(new ComparadorPorNombreAlumno());
        lista2.add(new Alumno(3, "Alberto"));
        lista2.add(new Alumno(1, "Luis"));
        lista2.add(new Alumno(2, "Mario"));
        lista2.add(new Alumno(1, "Luis")); // añade 
        lista2.add(new Alumno(4, "Maria"));
        
        GestionNotas.crearListaAsistenciaAlumnos(lista2);
        
    }//main
    
}
