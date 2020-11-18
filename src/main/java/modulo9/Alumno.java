
package modulo9;

public class Alumno implements Comparable<Alumno> {
    
    private int dni;
    private String nombre;

    public Alumno(int dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Alumno{" + "dni=" + dni + ", nombre=" + nombre + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.dni;
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
        final Alumno other = (Alumno) obj;
        if (this.dni != other.dni) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Alumno a) {
        // negativo menor 
        // cero igual
        // positivo mayor
        if( a  == null){
            return 0;
        }
       return this.dni - a.dni;
    }
    
    
    
}
