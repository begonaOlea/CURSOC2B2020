package agenda;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestAgenda {
    
    public static void main(String[] args) {
        
        Agenda agenda = new Agenda();
        
        Tarea t1 = new Tarea(Prioridad.ALTA,"Diseñar Base de Datos");
        Tarea t2 = new Tarea(Prioridad.MEDIA,"Refactorizar listados"); 
        Tarea t3 = new Tarea(Prioridad.MEDIA,"Generar informes"); 
        
        //añadir 3 tareas
        agenda.addTareaToDo(t1);
        agenda.addTareaToDo(t2);
        agenda.addTareaToDo(t3);
        
        agenda.mostrarListaToDo();
        agenda.mostrarListaDone();
         
        //tarea 2 completada
        agenda.pasarTareaToDoADone(t2);
        
        agenda.mostrarListaToDo();
        agenda.mostrarListaDone();
        
        
        try {
            Tarea encontrada = agenda.buscarTareaToDoPorDescripcion("Generar informes");
            System.out.println("TArea encontrada " + encontrada);
        } catch (AgendaException ex) {
            
            System.out.println(ex.getMessage());
        }
        
    }
    
}
