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
            //Solicito una conexion que me da de Pool de conexiones libres
            Connection con = PoolConexiones.getConnection();
            System.out.println("Conexión " + con);
        } //fin main
        catch (SQLException ex) {
            Logger.getLogger(PruebaPool.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
       
    }

}
