package com.shop;

import com.db.PoolConexiones;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InformesTiendaCafes {
    
    
    public static void cafesPorProveedor(){
        
        Connection con = PoolConexiones.getConexionLibre();
        if(con != null){
            try {
                //consulta
                String query = "select sup_id, "
                        + "count(cof_name) as numero_cafes "
                        + "from coffees "
                        + "group by sup_id";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query);
                while(rs.next()){
                    System.out.printf(" Proveedor %d cafes %d %n",
                            rs.getInt(1),
                            rs.getInt(2)
                    );
                }
                PoolConexiones.liberaConexion(con);
            } //hay conexion
            catch (SQLException ex) {
                Logger.getLogger(InformesTiendaCafes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            System.out.println("No se puede generar informe");
        }
    }
    
}
