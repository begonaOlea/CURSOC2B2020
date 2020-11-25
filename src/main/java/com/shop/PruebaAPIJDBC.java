package com.shop;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PruebaAPIJDBC {
    
    public static void main(String[] args) {
        
        /*
         1. Cargar Driver  base de datos JavaDB (Derby)
               DriverManager
         2. Obtener una conexión
               Connection
         3. Obtener una sentencia para lanzar una instruccion
               Statement
        */
        
        try {
            System.out.println("Intentando cargar driver");
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            System.out.println("Cargo ok el driver");
            
            //conectar con la bd CoffeeShop
            String url = "jdbc:derby://localhost:1527/CoffeeShop";
            //usuario y clave no tiene
            System.out.println("... obtener conexión con la bd");
            
            Connection con = DriverManager.getConnection(url);
            
            System.out.println(".... ok conexión");
            
            //crear la tabla 
            String create = "CREATE TABLE COFFEES " +
            "           (COF_NAME VARCHAR(32), " +
            "      SUP_ID INTEGER, " +
            "      PRICE FLOAT, " +
            "      SALES INTEGER, " +
            "      TOTAL INTEGER)";
            
            Statement sentencia = con.createStatement();
            //ejecuto
            sentencia.execute(create);
            
            
            
            
        } catch (ClassNotFoundException e){
            System.out.println("Error carga Driver: " + e.getMessage() );
        } catch (SQLException ex) {
            System.out.println("Error DB: " + ex.getMessage());
        }
        
        
    }//fin main
    
}//fin class
