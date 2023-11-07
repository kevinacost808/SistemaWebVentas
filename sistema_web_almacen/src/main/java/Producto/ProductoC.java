package Producto;

import java.util.List;

public class ProductoC {
    ProductoJpa productoControler = new ProductoJpa();

    public ProductoC() {
    }
    
    public List<Producto> consultarProducto (){
        return productoControler.consultarProducto();
    }
    
    public Producto consultarProductoId(String codigoProducto){
        return productoControler.consultarProductoId(codigoProducto);
    }
    
    public void agregarProducto(Producto producto){
        productoControler.agregarProducto(producto);
    }
    
    public void editarProducto(Producto producto){
        productoControler.editarProducto(producto);
    }
    
    public void eliminarProducto(String codigoProducto){
        productoControler.eliminarProducto(codigoProducto);
    }
}
