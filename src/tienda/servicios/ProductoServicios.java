package tienda.servicios;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import tienda.entidades.Fabricante;
import tienda.entidades.Producto;
import tienda.persistencia.DAO;

public class ProductoServicios {

    
public void listarNombreProductos() throws Exception {
        try {
            String sql = "SELECT codigo,nombre FROM producto;";

            ResultSet resultSet = DAO.queryDatabase(sql);
            System.out.printf("%-20s%-20s\n", "CODIGO PRODUCTO", "NOMBRE PRODUCTO");
            while (resultSet.next()) {
                System.out.printf("%-20s%-20s\n", 
                        resultSet.getInt(1), //pongo nros y strings para recordar que se puede de las 2 formas
                        resultSet.getString(2));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al mostrar productos");
        } finally {
            DAO.disconnectDatabase();
        }
    }
    
// b) Lista los nombres y los precios de todos los productos de la tabla producto.
    public void listarTodosProductos() throws Exception {
        try {
            String sql = "SELECT * FROM producto JOIN fabricante ON producto.codigo_fabricante=fabricante.codigo;";

            ResultSet resultSet = DAO.queryDatabase(sql);
            System.out.printf("%-20s%-35s%-20s%-20s%-20s\n", "CODIGO PRODUCTO", "NOMBRE PRODUCTO", "PRECIO PRODUCTO", "CODIGO FABRICANTE", "NOMBRE FABRICANTE");
            while (resultSet.next()) {
                System.out.printf("%-20s%-35s%-20s%-20s%-20s\n", 
                        resultSet.getInt("producto.codigo"), //pongo nros y strings para recordar que se puede de las 2 formas
                        resultSet.getString("producto.nombre"), 
                        resultSet.getDouble("producto.precio"),
                        resultSet.getInt("producto.codigo_fabricante"),
                        resultSet.getString("fabricante.nombre"));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al mostrar productos");
        } finally {
            DAO.disconnectDatabase();
        }
    } 
    
    //c) Listar aquellos productos que su precio esté entre 120 y 202.
    public void listarProductosPorRangoPrecio(Double inferior,Double superior) throws Exception{
        try {
            String sql = "SELECT * FROM producto JOIN fabricante ON producto.codigo_fabricante=fabricante.codigo WHERE precio>="+inferior+"AND precio<="+superior+"ORDER BY precio ASC;";

            ResultSet resultSet = DAO.queryDatabase(sql);
            System.out.printf("%-20s%-35s%-20s%-20s%-20s\n", "CODIGO PRODUCTO", "NOMBRE PRODUCTO", "PRECIO PRODUCTO", "CODIGO FABRICANTE", "NOMBRE FABRICANTE");
            while (resultSet.next()) {
                System.out.printf("%-20s%-35s%-20s%-20s%-20s\n", 
                        resultSet.getInt("producto.codigo"),  
                        resultSet.getString("producto.nombre"), 
                        resultSet.getDouble("producto.precio"),
                        resultSet.getInt("producto.codigo_fabricante"),
                        resultSet.getString("fabricante.nombre"));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al mostrar productos");
        } finally {
            DAO.disconnectDatabase();
        }
    }
    
//d) Buscar y listar todos los Portátiles de la tabla producto.
    public void listarPortatiles() throws Exception{
        try {
            String sql = "SELECT * FROM producto JOIN fabricante ON producto.codigo_fabricante=fabricante.codigo WHERE producto.nombre like '%portatil%';";

            ResultSet resultSet = DAO.queryDatabase(sql);
            System.out.printf("%-20s%-35s%-20s%-20s%-20s\n", "CODIGO PRODUCTO", "NOMBRE PRODUCTO", "PRECIO PRODUCTO", "CODIGO FABRICANTE", "NOMBRE FABRICANTE");
            while (resultSet.next()) {
                System.out.printf("%-20s%-35s%-20s%-20s%-20s\n", 
                        resultSet.getInt("producto.codigo"),  
                        resultSet.getString("producto.nombre"), 
                        resultSet.getDouble("producto.precio"),
                        resultSet.getInt("producto.codigo_fabricante"),
                        resultSet.getString("fabricante.nombre"));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al mostrar productos");
        } finally {
            DAO.disconnectDatabase();
        }
    }
    
    //e) Listar el nombre y el precio del producto más barato.
    public void productoMasBarato() throws Exception{
        try {
            String sql = "SELECT * FROM producto JOIN fabricante ON producto.codigo_fabricante=fabricante.codigo WHERE producto.precio=(SELECT MIN(precio) FROM producto);";

            ResultSet resultSet = DAO.queryDatabase(sql);
            System.out.printf("%-20s%-35s%-20s%-20s%-20s\n", "CODIGO PRODUCTO", "NOMBRE PRODUCTO", "PRECIO PRODUCTO", "CODIGO FABRICANTE", "NOMBRE FABRICANTE");
            while (resultSet.next()) {
                System.out.printf("%-20s%-35s%-20s%-20s%-20s\n", 
                        resultSet.getInt("producto.codigo"),  
                        resultSet.getString("producto.nombre"), 
                        resultSet.getDouble("producto.precio"),
                        resultSet.getInt("producto.codigo_fabricante"),
                        resultSet.getString("fabricante.nombre"));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al mostrar productos");
        } finally {
            DAO.disconnectDatabase();
        }
    }
    
    
}
/*
a) Lista el nombre de todos los productos que hay en la tabla producto.
b) Lista los nombres y los precios de todos los productos de la tabla producto.
c) Listar aquellos productos que su precio esté entre 120 y 202.
d) Buscar y listar todos los Portátiles de la tabla producto.
e) Listar el nombre y el precio del producto más barato.
f) Ingresar un producto a la base de datos.
g) Ingresar un fabricante a la base de datos
h) Editar un producto con datos a elección.

 */
