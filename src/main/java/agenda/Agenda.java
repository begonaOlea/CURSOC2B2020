
package agenda;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


public class Agenda {
    
    private Set<Tarea> toDoList ;
    private Set<Tarea> doneList;

    public Agenda() {
        this.toDoList = new HashSet<Tarea>();
        this.doneList = new HashSet<Tarea>();
    }
    
    public void addTareaToDo(Tarea t){
        toDoList.add(t);
    }
    
    public void pasarTareaToDoADone(Tarea t){
        toDoList.remove(t);
        t.setFechaRealizacion(new Date());
        doneList.add(t);
    }
    
    public void mostrarListaToDo(){
        System.out.println("....... TAREAS PENDIENTE ..........");
        if(toDoList.isEmpty()){
             System.out.println("... no hay tareas pendientes");
             return;
         }
        for(Tarea t : toDoList){
            System.out.println(fechaFormateada(t.getFechaCreacion()) + 
                    " - " + t.getDescripcion() + " - Prioridad " + t.getPrioridad());
        }
        System.out.println("____________________________________________________");
        
    }
    
    public void mostrarListaDone(){
         System.out.println("....... TAREAS COMPLETADAS  ..........");
         if(doneList.isEmpty()){
             System.out.println("... no hay tareas completadas");
             return;
         }
        for(Tarea t : doneList){
            System.out.println(fechaFormateada(t.getFechaCreacion()) + 
                    "  " + t.getDescripcion() 
            + "realizada el " + fechaFormateada(t.getFechaRealizacion()));
        }
    }
    
    private String fechaFormateada(Date d){
        DateFormat df = DateFormat.getDateTimeInstance();
        return df.format(d);
    }
}
