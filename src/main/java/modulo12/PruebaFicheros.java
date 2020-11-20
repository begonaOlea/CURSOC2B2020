package modulo12;

import java.io.File;
import java.io.IOException;


public class PruebaFicheros {
    
    public static void main(String[] args) throws IOException {
        
        File dir = new File ("dir1");
         
        if(! dir.exists() ){
            System.out.println("dir 1 no existe. Creo el directorio");
            dir.mkdir();
        }else{
            System.out.printf(" el directorio %s ya existe", dir.getName());
        }
        
        File fichero = new File(dir, "carta.txt");
        
        if(! fichero.exists()){
            System.out.println("creo el fichero");
            fichero.createNewFile();
        }else{
            System.out.println("El fichero ya existe");
        }
        System.out.printf("Ruta parcial %s y ruta completa %s",
                fichero.getPath(),
                fichero.getAbsolutePath());
    }//fin main 
    
}
