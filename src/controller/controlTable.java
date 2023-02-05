package controller;



import model.Producto;

import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;


/**
 *
 * @author Salamanca
 */

public class controlTable implements TableModel {

    List<Producto> ListaProducto;
    String[] Columnas;
    TableModelListener tableModelListener;

    public controlTable(List<Producto>ListaProducto){
        this.ListaProducto = ListaProducto;
        this.Columnas = new String[]{"Nombre","Precio","Inventario"};
    }

    @Override
    public int getRowCount(){
        return this.ListaProducto.size();
    }

    @Override
    public int getColumnCount(){
        return this.Columnas.length;
    }

    @Override
    public String getColumnName(int columnIndex){
        return this.Columnas[columnIndex];
    }

    @Override
    public Class<?> getColumnClass (int columnIndex){
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return Double.class;
            case 2:
                return Integer.class;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        Producto Produc = this.ListaProducto.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Produc.getNombre();
            case 1:
                return Produc.getPrecio();
            case 2:
                return Produc.getInventario();
        }
        return null;
    }

    @Override
    public void setValueAt(Object ProductoN, int rowIndex, int columnIndex){
        Producto Product = this.ListaProducto.get(rowIndex);
        switch (columnIndex) {
            case 0:
                Product.setNombre(String.valueOf(ProductoN));
            case 1:
                Product.setPrecio((Double)ProductoN);
            case 2:
                Product.setInventario((int)ProductoN);
        }
        this.ListaProducto.set(rowIndex, Product);

    }

    @Override
    public void  addTableModelListener(TableModelListener i ){
        this.tableModelListener = i;
    }

    @Override
    public void removeTableModelListener(TableModelListener i){
        this.tableModelListener = null;
    }


}

