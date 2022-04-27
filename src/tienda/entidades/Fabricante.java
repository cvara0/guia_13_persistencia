package tienda.entidades;

import java.util.ArrayList;

public class Fabricante {

    private Integer codigo;
    private String nombre;
    private ArrayList<Producto> listaProductos;

    public Fabricante() {
    }

    public Fabricante(Integer codigo, String nombre, ArrayList<Producto> listaProductos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.listaProductos = listaProductos;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

}
