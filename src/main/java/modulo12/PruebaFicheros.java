package modulo12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

public class PruebaFicheros {

    public static void main(String[] args) throws IOException {

        File dir = new File("dir1");

        if (!dir.exists()) {
            System.out.println("dir 1 no existe. Creo el directorio");
            dir.mkdir();
        } else {
            System.out.printf(" el directorio %s ya existe", dir.getName());
        }

        File fichero = new File(dir, "carta.txt");

        if (!fichero.exists()) {
            System.out.println("creo el fichero");
            fichero.createNewFile();
        } else {
            System.out.println("El fichero ya existe");
        }
        System.out.printf("Ruta parcial %s y ruta completa %s",
                fichero.getPath(),
                fichero.getAbsolutePath());

        //ESCRIBIR EN EL FICHERO
        FileWriter fw = null;
        PrintWriter out = null;
        try {
            fw = new FileWriter(fichero,true);
             out = new PrintWriter(fw);
            
            out.println("Esto es una linea. ");
            out.println("Esto es otra linea. ") ;      
//            fw.write("Esto es una primera línea.");
//            fw.write("\n");
//            fw.write("Esto es una segunda línea.");
//            fw.write("\n");
            
        } catch (IOException e) {
             System.out.println("No se ha podido escribir");
        } finally {
           if (fw != null) fw.close();
           if (out != null) out.close();
        }
        
        
        // LEER FICHERO
        System.out.println(".... leyendo ......");
        FileReader fr = null;
        try{
           fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while(linea != null){
                 System.out.println(linea);
                  linea = br.readLine();
            }//fin fichero
        }catch(IOException e){
            System.out.println("No pudo leer " + e.getMessage());
        }finally{
            if (fr != null ) fr.close();
        } 
        
    }//fin main 

}
