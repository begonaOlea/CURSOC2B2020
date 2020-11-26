package com.shop;

import com.db.PoolConexiones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionarCafes {
    
    public void modificarVentas(String nombre, int ventas) 
            throws TiendaCafesException, SQLException{
        
        String updateString = "UPDATE COFFEES " +
                 " SET SALES = " + ventas +
                 " WHERE COF_NAME LIKE '" +  nombre +  "'";
          
        
        Connection con = PoolConexiones.getConexionLibre();
        if(con == null){
            throw new TiendaCafesException("Tienda. No se puede modificar ventas. No hay conexión db");
        }

        Statement st = con.createStatement();
        int modificados = st.executeUpdate(updateString);
        if (modificados == 0){
            throw new TiendaCafesException(("Tienda. No existe el  café " + nombre));
        }
        
        PoolConexiones.liberaConexion(con);
        
    }//fin metodo
    
    
    
     public void modificarVentasPrepared(String nombre, int ventas) 
            throws TiendaCafesException, SQLException{
        
        String updateString = "UPDATE COFFEES " +
                 "SET SALES = ? " +
                 "WHERE COF_NAME LIKE ?";

        Connection con = PoolConexiones.getConexionLibre();
        if(con == null){
            throw new TiendaCafesException("Tienda. No se puede modificar ventas. No hay conexión db");
        }

        PreparedStatement st = con.prepareStatement(updateString);
        st.setInt(1, ventas);
        st.setString(2, nombre);
        
        int modificados = st.executeUpdate();
        if (modificados == 0){
            throw new TiendaCafesException(("Tienda. No existe el  café " + nombre));
        }
        
        PoolConexiones.liberaConexion(con);
        
    }//fin metodo
    
}
