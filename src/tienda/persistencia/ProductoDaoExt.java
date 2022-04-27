package tienda.persistencia;

import java.util.ArrayList;
import java.util.List;
import tienda.entidades.Fabricante;
import tienda.entidades.Producto;

public class ProductoDaoExt extends DAO {

    public void guardarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("El producto no puede ser nulo");
            }
            String plantilla = "INSERT INTO producto VALUES (NULL,'%s','%s','%s');";
            String sql = String.format(plantilla, producto.getNombre(), producto.getPrecio(), producto.getFabricante().getCodigo());
            insertModifyDelete(sql);
            System.out.println("Producto agregado");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al guardar producto");
        }
    }

    public void modificarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("El producto no puede ser nulo");
            }
            String plantilla = "UPDATE producto SET nombre='%s',precio='%s',codigo_fabricante='%s' WHERE codigo='%s';";
            String sql = String.format(plantilla, producto.getNombre(), producto.getPrecio(), producto.getFabricante().getCodigo(), producto.getCodigo());
            insertModifyDelete(sql);
            System.out.println("Producto actualizado");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al modificar producto");
        }
    }

    public void eliminarProducto(String sql) throws Exception {

        try {
            insertModifyDelete(sql);
            System.out.println("Producto eliminado");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al eliminar producto");
        }
    }

    public List<Producto> obtenerProducto() throws Exception {
        try {
            
            String plantilla = "SELECT * FROM producto;";
            //String sql=String.format(plantilla, codigo);
            queryDatabase(plantilla);

            List<Producto> productos = new ArrayList<>();
            Producto producto;
            Fabricante fabricante;
            while (resultSet.next()) {
                producto = new Producto();
                fabricante=new Fabricante();
                
                producto.setCodigo(resultSet.getInt(1));
                producto.setNombre(resultSet.getString(2));
                producto.setPrecio(resultSet.getDouble(3));
                fabricante.setCodigo(resultSet.getInt(4));
                producto.setFabricante(fabricante);
                
                productos.add(producto);
            }
            for(Producto i:productos){
                System.out.println(i.getCodigo()+","+i.getNombre()+",  "+i.getFabricante().getCodigo());
            }
            return productos;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al obtener producto");
        } finally {
            disconnectDatabase();
        }

    }

}
