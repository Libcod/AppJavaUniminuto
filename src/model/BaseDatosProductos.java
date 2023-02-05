package model;


import model.Producto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Salamanca
 */
public class BaseDatosProductos {

    private Map<Integer, Producto> listaProductos = new HashMap<Integer, Producto>();

    public BaseDatosProductos() {

        listaProductos.put(1, new Producto(1, "Manzanas", 5000.0, 25));
        listaProductos.put(2, new Producto(2, "Peras", 3000.0, 30));
        listaProductos.put(3, new Producto(3, "Arandanos", 300.0, 10));
        listaProductos.put(4, new Producto(4, "Tomates", 2000.0, 5));
        listaProductos.put(5, new Producto(5, "Fresas", 100.0, 55));
        listaProductos.put(6, new Producto(6, "Galletas", 6000.0, 35));

    }

    public List<Producto> getBaseDatos(){
        return new ArrayList<> (this.listaProductos.values());
    }

    public void agregar(Producto producto) {
        listaProductos.put(producto.getCodigo(), producto);

    }

    public void borrar(Producto producto) {
        listaProductos.remove(producto.getCodigo());

    }

    public void actualizar(Producto producto) {
        listaProductos.replace(producto.getCodigo(), producto);

    }

    public boolean verificarExistencia(Producto producto) {
        return listaProductos.containsKey(producto.getCodigo());

    }

    public Producto precioMayor() {
        Producto producto = listaProductos.values().iterator().next();
        for (Producto pro : listaProductos.values()) {
            if (pro.getPrecio() > producto.getPrecio()) {
                producto = pro;
            }
        }
        return producto;
    }

    public String[] generarInforme() {
        return nombresMayores();

    }

    public String[] nombresMayores(){
        double cont = 0;

        String arreglo[] =  new String[3];
        arreglo[0] = "";
        arreglo[1] = "";
        arreglo[2] = "";

        int i = 0;
        while(i != 3){
            for(int key : listaProductos.keySet()){
                Producto miProducto =  listaProductos.get(key);
                double precio3 =  miProducto.getPrecio();
                String cont3 =  miProducto.getNombre();
                if(precio3 > cont && arreglo[0].equals(cont3)== false
                        && arreglo[1].equals(cont3)== false
                        && arreglo[2].equals(cont3)== false)
                {
                    cont =  precio3;
                    arreglo[i] = cont3;
                }
            }
            i += 1;
            cont = 0 ;
        }

        return arreglo;

    }

    public int codigoMayor() {
        int codigoAUX = 0;
        for(Producto items: listaProductos.values()){
            if(items.getCodigo() > codigoAUX){
                codigoAUX = items.getCodigo();
            }
        }
        return codigoAUX;
    }


    public int consultarCodigo(String nombre){
        int codigo = 0;
        for(Producto items: listaProductos.values()){
            if(nombre.equals(items.getNombre())){
                codigo = items.getCodigo();
            }
        }
        return codigo;
    }

    public Producto productoSeleccionadoBaseDatos(int i){
        return this.listaProductos.get(i);
    }
}
