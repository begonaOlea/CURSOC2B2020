
package agenda;

import java.util.Date;
import java.util.Objects;


public class Tarea {
    
    private Date fechaCreacion;
    private Prioridad prioridad;
    private String descripcion;
    private Date fechaRealizacion;

    public Tarea(Prioridad prioridad, String descripcion) {
        this.prioridad = prioridad;
        this.descripcion = descripcion;
        this.fechaCreacion = new Date(); //fecha sistema
        this.fechaRealizacion = null;
    }

    public Tarea(String descripcion) {
        this.descripcion = descripcion;
        this.prioridad = Prioridad.BAJA;
        this.fechaCreacion = new Date(); //fecha sistema
        this.fechaRealizacion = null;
    }
    
    

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public Date getFechaRealizacion() {
        return fechaRealizacion;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setFechaRealizacion(Date fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.fechaCreacion);
        hash = 23 * hash + Objects.hashCode(this.descripcion);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tarea other = (Tarea) obj;
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.fechaCreacion, other.fechaCreacion)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tarea{" + "fechaCreacion=" + fechaCreacion + ", prioridad=" + prioridad + ", descripcion=" + descripcion + ", fechaRealizacion=" + fechaRealizacion + '}';
    }

    
  
}
