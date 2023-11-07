package Producto;

import Excepcion.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductoJpa {
    
    ProductoJpaController productoJpa = new ProductoJpaController();

    public ProductoJpa() {
    }
    
    public List<Producto> consultarProducto (){
        return productoJpa.findProductoEntities();
    }
    
    public Producto consultarProductoId(int id){
        return productoJpa.findProducto(id);
    }
    
    public void agregarProducto(Producto producto){
        productoJpa.create(producto);
    }
    
    public void editarProducto(Producto producto){
        try {
            productoJpa.edit(producto);
        } catch (Exception ex) {
            Logger.getLogger(ProductoJpa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarProducto(int id){
        try {
            productoJpa.destroy(id);
        } catch (Excepcion.NonexistentEntityException ex) {
            Logger.getLogger(ProductoJpa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
