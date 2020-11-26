
package com.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class InformeCuentasBancarias {
    
    private static Connection con = null;

    static {

        try {
            //driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            //conexion
            String url = "jdbc:derby://localhost:1527/Bank";
            con = DriverManager.getConnection(url);

        } catch (ClassNotFoundException ex) {
            System.out.println("Error cargar Driver:" + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error conexión: " + ex.getMessage());
        }

    }

    /**
     * Muestra IBAN SALDO NOMBRE_BANCO NOMBRE + APELLIDOS DE TODOS LOS CLIENTES
     */
    public static void informeCuentasBancariasPorConsola() {

        try {
            Statement setencia = con.createStatement();

            String consultaBank = "SELECT IBAN, B.NOMBRE AS NOMBRE_BANCO, "
                    + "C.NOMBRE, C.APELLIDOS, CB.SALDO "
                    + "FROM CLIENTES C "
                    + "INNER JOIN CUENTAS_BANCARIAS CB "
                    + "ON C.ID_CLIENTE = CB.ID_CLIENTE "
                    + "INNER JOIN BANCOS B "
                    + "ON C.ID_BANCO = B.ID_BANCO ";

            ResultSet resultado = setencia.executeQuery(consultaBank);

            while (resultado.next()) {
                System.out.printf("IBAN: %-20s "
                        + "Banco: %10s "
                        + "Cliente: %-10s %-10s "
                        + "Saldo: %10.2f \n",
                        resultado.getString(1),
                        resultado.getString(2),
                        resultado.getString(3),
                        resultado.getString(4),
                        resultado.getDouble(5));
            }
        } catch (SQLException ex) {
            System.out.println("No se ha podido realizar la consulta" + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void cerrarConexion() {
        if (con != null) try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(InformeCuentasBancarias.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        InformeCuentasBancarias.informeCuentasBancariasPorConsola();
        InformeCuentasBancarias.cerrarConexion();

    }
}//fin clase