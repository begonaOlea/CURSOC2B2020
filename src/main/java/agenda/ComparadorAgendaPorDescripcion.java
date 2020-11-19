
package agenda;

import java.util.Comparator;

public class ComparadorAgendaPorDescripcion implements Comparator<Tarea> {

    @Override
    public int compare(Tarea t1, Tarea t2) {
         return t1.getDescripcion().compareTo(t2.getDescripcion());
    }
    
}
