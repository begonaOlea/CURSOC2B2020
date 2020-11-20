
package modulo12;

import agenda.Prioridad;
import agenda.Tarea;

public class PruebaFormat {
  
    public static void main(String[] args) {

        // dar formato de salida 
        
        Tarea t = new Tarea(Prioridad.ALTA,"Subir aplicación a producción");
        
        System.out.printf("Tarea %-40s tiene prioridad %s.",
                t.getDescripcion(),
                t.getPrioridad());
        
        String linea = String.format("Tarea %s", t.getDescripcion());
        
        
        
          
    }// fin main
}
