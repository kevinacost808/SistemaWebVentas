package Producto;

import java.util.List;

public class ProductoC {
    ProductoJpa productoControler = new ProductoJpa();

    public ProductoC() {
    }
    
    public List<Producto> consultarProducto (){
        return productoControler.consultarProducto();
    }
    
    public Producto consultarProductoId(int id){
        return productoControler.consultarProductoId(id);
    }
    
    public void agregarProducto(Producto producto){
        productoControler.agregarProducto(producto);
    }
    
    public void editarProducto(Producto producto){
        productoControler.editarProducto(producto);
    }
    
    public void eliminarProducto(int id){
        productoControler.eliminarProducto(id);
    }
}
