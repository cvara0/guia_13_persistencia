package tienda.main;

import tienda.persistencia.DAO;
import tienda.persistencia.ProductoDaoExt;
import tienda.servicios.ProductoServicios;

public class TiendaMain {

    public static void main(String[] args) throws Exception {
        ProductoServicios objeto = new ProductoServicios();
        //objeto.listarTodosProductos();
        //objeto.listarNombreProductos();
        //objeto.listarProductosPorRangoPrecio(120.00,202.00);
        //objeto.listarPortatiles();
        objeto.productoMasBarato();
    }

}
