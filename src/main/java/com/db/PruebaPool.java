package com.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PruebaPool {

    public static void main(String[] args) {

        
        try {
            int n = PoolConexiones.getNumeroMaxConexiones();
            System.out.printf(" Pool con un maximo de %d conexiones", n);
            System.out.printf(" Total libres %d y total ocupadas %d %n",
                     PoolConexiones.getTotalConexionesLibres(), 
                     PoolConexiones.getTotalConexionesOcupadas());
            
            //Solicito una conexion que me da de Pool de conexiones libres
            Connection con = PoolConexiones.getConexionLibre();
            System.out.println("Conexión " + con);
            
            
            System.out.printf(" Total libres %d y total ocupadas %d %n ",
                     PoolConexiones.getTotalConexionesLibres(), 
                     PoolConexiones.getTotalConexionesOcupadas());
            
            Connection con2 = PoolConexiones.getConexionLibre();
            System.out.println("Conexión " + con2);
            
            
            System.out.printf(" Total libres %d y total ocupadas %d %n ",
                     PoolConexiones.getTotalConexionesLibres(), 
                     PoolConexiones.getTotalConexionesOcupadas());
            
            //liberar
            System.out.println("libero con");
            PoolConexiones.liberaConexion(con);
            PoolConexiones.liberaConexion(con2);
            
             System.out.printf(" Total libres %d y total ocupadas %d %n ",
                     PoolConexiones.getTotalConexionesLibres(), 
                     PoolConexiones.getTotalConexionesOcupadas());
       
        }catch (Exception ex) {
            Logger.getLogger(PruebaPool.class.getName()).log(Level.SEVERE, null, ex);
        } 
       
    }

}
