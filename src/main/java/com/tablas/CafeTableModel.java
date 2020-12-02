
package com.tablas;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class CafeTableModel extends AbstractTableModel  {

    //atributos
    private String[] nombreColumnas = {"ID CAFE", "NOMBRE" , "STOCK"};
    private List<Cafe> datos;

    //consturctor 
    public CafeTableModel(List<Cafe> datos) {
        this.datos = datos;
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cafe cafe = datos.get(rowIndex);
        Object valor = null;
        switch(columnIndex){
            case 0: 
                valor = cafe.getId();
                break;
            case 1:
                valor = cafe.getNombre();
                break;
            case 2:
                valor = cafe.getCantidad();
        }//fin
        
        return valor;  
    }

    @Override
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }
    
    
}
