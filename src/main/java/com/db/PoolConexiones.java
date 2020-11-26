package com.db;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PoolConexiones {

    private static DriverManager dm;
    private static int numeroMaxConexiones;
    private static final int NUM_MIN_CONEXIONES = 3;
    private static String driverClass;
    private static String url;
    private static String usuario;
    private static String clave;
    
    private static LinkedList<Connection> conexionesLibres;
    private static LinkedList<Connection> conexionesOcupadas;

    static  {
        Properties prop  = null;
        try {
            //leer el fichero de propiedades
            prop = new Properties();
            prop.load(new FileReader("db/db.properties"));
            numeroMaxConexiones = Integer.parseInt(
                    prop.getProperty("numero_max_conexiones", ""+NUM_MIN_CONEXIONES)
                    );
            driverClass = prop.getProperty("driver_class");
            url  = prop.getProperty("url_conexion");
            usuario = prop.getProperty("usuario");
            clave = prop.getProperty("clave");
            
            //cargar driver
            Class.forName(driverClass);
        } catch(ClassNotFoundException ef){
            System.out.println("No pudo cargar el driver "+ ef.getMessage());
        }catch (Exception ex) {
            System.out.println("Error leer parametro crear Pool " + ex.getMessage() );
        }
    }//fin static

    public static int getNumeroMaxConexiones() {
        return numeroMaxConexiones;
    }

    private static Connection getConnection() throws SQLException{
        Connection con  = null;
        if(usuario !=null && usuario.length() > 0){
            con = DriverManager.getConnection(url,usuario,clave);
        }else{
           con = DriverManager.getConnection(url);
        }
        return con; 
    }
    
 
    private static void inicializarPool() throws SQLException{
         
        //crear  coleccion conexiones libres
        conexionesLibres = new LinkedList<Connection>();
        //añadir nuevas conexiones
        for(int i = 0 ; i < numeroMaxConexiones; i++){
            Connection con = getConnection();
            conexionesLibres.add(con);
        }
        
        //crear coleccion conexiones ocupadas
        conexionesOcupadas = new LinkedList<Connection>();
 
    }
    
    public static Connection getConexionLibre(){
        
        return null;
    }
    
    public static void liberaConexion(Connection con){
        
    }

} //fin PoolConexiones


/*
     1. Leer de un fichero de propiedades   .properties  los
        datos para crear el pool:
           . driver_class
           . numero_max_conexiones
           . url_conexion
           . usuario
           . clave

*/
