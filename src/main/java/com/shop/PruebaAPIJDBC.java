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
         4. Ejecutar sentencia generalista - execute
            Ejecutar sentencia cambia algo  - executeUpdate 
                   que retorna el número de reg afectados
         5. Consultar todos cafés
            Ejecutamos la sentencia SELEC - executeQuery
                    que retorna un ResulSet  (resultado en forma de tabla)
         */
        Connection con = null;
        try {
            System.out.println("Intentando cargar driver");
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            System.out.println("Cargo ok el driver");

            //conectar con la bd CoffeeShop
            String url = "jdbc:derby://localhost:1527/CoffeeShop";
            //usuario y clave no tiene
            System.out.println("... obtener conexión con la bd");

            con = DriverManager.getConnection(url);

            System.out.println(".... ok conexión");

            //crear la tabla 
            String create = "CREATE TABLE COFFEES "
                    + "           (COF_NAME VARCHAR(32), "
                    + "      SUP_ID INTEGER, "
                    + "      PRICE FLOAT, "
                    + "      SALES INTEGER, "
                    + "      TOTAL INTEGER)";

            Statement sentencia = con.createStatement();
            //ejecuto
            // sentencia.execute(create);

            //insertar datos en la tabla COFFEES
            String poblarTabla = "INSERT INTO COFFEES "
                    + "VALUES ('Colombian', 101, 7.99, 0, 0),"
                    + "('French_Roast', 49, 8.99, 0, 0), "
                    + "('Espresso', 150, 9.99, 0, 0), "
                    + "('Colombian_Decaf', 101, 8.99, 0, 0), "
                    + "('French_Roast_Decaf', 49, 9.99, 0, 0)";

           // int filasInsertadas = sentencia.executeUpdate(poblarTabla);
           // System.out.printf("Ha insertado %d cafés.", filasInsertadas);

            //consultar los cafés de la tabla
            String consultaCafes = "SELECT * FROM COFFEES";

            ResultSet resultado = sentencia.executeQuery(consultaCafes);
            //boolean hay = resultado.next(); 
            //if(hay){
            while (resultado.next()) {
                System.out.printf("café %-30s del proveedor id %6d a %10.2f€. Total Venta %d - %d ",
                        resultado.getString(1), //  cof_name
                        resultado.getInt(2), // sup_id
                        resultado.getDouble(3), // price
                        resultado.getInt("sales"),
                        resultado.getInt("total")
                );
                System.out.println("");
            }//fin recorrer resultados

        } catch (ClassNotFoundException e) {
            System.out.println("Error carga Driver: " + e.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error DB: " + ex.getMessage());
        }finally{
            if(con != null) try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(PruebaAPIJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//fin main

}//fin class
